package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.FIFTH_PRIZE_AMOUNT
import util.Constants.FIRST_PRIZE_AMOUNT
import util.Constants.FOURTH_PRIZE_AMOUNT
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Constants.LOTTO_MAX_NUMBER
import util.Constants.LOTTO_MIN_NUMBER
import util.Constants.LOTTO_TOTAL_NUMBER
import util.Constants.SECOND_PRIZE_AMOUNT
import util.Constants.THIRD_PRIZE_AMOUNT

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val numberOfPurchases = getNumberOfPurchases()
        val lottos = makeLottos(numberOfPurchases)
        purchaseLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        val winningRanks = getWinningRanks(lottos, winningNumbers, bonusNumber)
        getRateOfReturn(numberOfPurchases, winningRanks)
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
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_TOTAL_NUMBER)
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

    fun getWinningRanks(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Int> {
        outputView.printWinningStatisticsInstruction()
        val winningStatistics = mutableListOf<Pair<Int, Boolean>>()
        for (lotto in lottos) {
            val matchedNumbers = lotto.getNumbers().intersect(winningNumbers).size
            val bonusMatched = lotto.getNumbers().contains(bonusNumber)
            winningStatistics.add(Pair(matchedNumbers, bonusMatched))
        }
        val winningRanks = judgementWinningRanks(winningStatistics)
        outputView.printWinningStatistics(winningRanks)
        return winningRanks
    }

    fun judgementWinningRanks(winningResults: List<Pair<Int, Boolean>>): List<Int> {
        val winningRanks = mutableListOf(0, 0, 0, 0, 0, 0)
        for (winningResult in winningResults) {
            val winningRank = when {
                winningResult.first == 6 -> 1
                winningResult.first == 5 && winningResult.second -> 2
                winningResult.first == 5 -> 3
                winningResult.first == 4 -> 4
                winningResult.first == 3 -> 5
                else -> 0
            }
            winningRanks[winningRank] += 1
        }
        return winningRanks
    }

    fun getRateOfReturn(numberOfPurchases: Int, winningRanks: List<Int>) {
        val purchaseAmount = numberOfPurchases * LOTTO_AMOUNT_UNIT
        var winningAmount = 0.0

        for (winningRank in 1..5) {
            winningAmount += calculateWinningAmount(winningRank, winningRanks[winningRank])
        }
        val rateOfReturn = (winningAmount / purchaseAmount) * 100
        outputView.printRateOfReturn(rateOfReturn)
    }

    fun calculateWinningAmount(winningRank: Int, numberOfWinningRank: Int): Int {
        return when(winningRank) {
            1 -> FIRST_PRIZE_AMOUNT * numberOfWinningRank
            2 -> SECOND_PRIZE_AMOUNT * numberOfWinningRank
            3 -> THIRD_PRIZE_AMOUNT * numberOfWinningRank
            4 -> FOURTH_PRIZE_AMOUNT * numberOfWinningRank
            5 -> FIFTH_PRIZE_AMOUNT * numberOfWinningRank
            else -> 0
        }
    }
}