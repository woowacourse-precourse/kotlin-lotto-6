package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Constants.LOTTO_NUMBER_END
import util.Constants.LOTTO_NUMBER_START
import util.Constants.LOTTO_TOTAL_NUMBER

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val numberOfPurchases = getNumberOfPurchases()
        val lottos = makeLottos(numberOfPurchases)
        purchaseLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        getWinningStatistics(lottos, winningNumbers, bonusNumber)
    }

    fun getNumberOfPurchases(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            val purchaseAmount = inputView.inputPurchaseAmount()
            purchaseAmount / LOTTO_AMOUNT_UNIT
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getNumberOfPurchases()
        }
    }

    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_TOTAL_NUMBER)
    }

    fun makeLottos(numberOfPurchase: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (number in 0 until numberOfPurchase) {
            lottos.add(Lotto(generateLottoNumbers()))
        }
        return lottos
    }

    fun purchaseLottos(lottos: List<Lotto>) {
        outputView.printNumberOfPurchases(lottos.size)
        for (lotto in lottos) {
            outputView.printLottoNumbers(lotto)
        }
    }

    fun getWinningNumbers(): List<Int> {
        outputView.printWinningNumbersInstruction()
        return try {
            val winnerNumbers = inputView.inputWinningNumbers()
            winnerNumbers
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        outputView.printBonusNumberInstruction()
        return try {
            val bonusNumber = inputView.inputBonusNumber(winningNumbers)
            bonusNumber
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getBonusNumber(winningNumbers)
        }
    }

    fun getWinningStatistics(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int) {
        outputView.printWinningStatisticsInstruction()
        val winningStatistics = mutableListOf<Pair<Int, Boolean>>()
        for (lotto in lottos) {
            val matchedNumbers = lotto.getNumbers().intersect(winningNumbers).size
            val bonusMatched = lotto.getNumbers().contains(bonusNumber)
            winningStatistics.add(Pair(matchedNumbers, bonusMatched))
        }
        outputView.printWinningStatistics(judgementWinningRanks(winningStatistics))
    }

    fun judgementWinningRanks(winningResults: List<Pair<Int, Boolean>>): List<Int> {
        val winningRanks = mutableListOf(0, 0, 0, 0, 0, 0)
        for (winningResult in winningResults) {
            val winningRank = when {
                winningResult.first == 6 -> 1
                winningResult.first == 5 && winningResult.second ->  2
                winningResult.first == 5 -> 3
                winningResult.first == 4 ->  4
                winningResult.first == 3 ->  5
                else -> 0
            }
            winningRanks[winningRank] += 1
        }
        return winningRanks
    }
}