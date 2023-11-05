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
        val purchaseAmount = getPurchaseAmount()
        val numberOfPurchases = getNumberOfPurchase(purchaseAmount)
        val lottos = makeLottos(numberOfPurchases)
        purchaseLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        val winningRanks = getWinningRanks(lottos, winningNumbers, bonusNumber)
        getRateOfReturn(purchaseAmount, winningRanks)
    }

    fun getPurchaseAmount(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            val purchaseAmount = inputView.inputPurchaseAmount()
            purchaseAmount
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getPurchaseAmount()
        }
    }

    fun getNumberOfPurchase(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_AMOUNT_UNIT
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
            outputView.printLotto(lotto)
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
            val matchedNumbers = getMatchedNumbers(lotto, winningNumbers)
            val bonusMatched = getBonusMatched(lotto, bonusNumber)
            winningStatistics.add(Pair(matchedNumbers, bonusMatched))
        }
        val winningRanks = judgementWinningRanks(winningStatistics)
        outputView.printWinningStatistics(winningRanks)
        return winningRanks
    }

    fun getMatchedNumbers(lotto: Lotto, winningNumbers: List<Int>): Int {
        return lotto.getNumbers().intersect(winningNumbers).size
    }

    fun getBonusMatched(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }

    fun judgementWinningRanks(winningStatistics: List<Pair<Int, Boolean>>): List<Int> {
        val winningRanks = mutableListOf(0, 0, 0, 0, 0, 0)
        for (winningStatistic in winningStatistics) {
            val winningRank = when {
                winningStatistic.first == 6 -> 1
                winningStatistic.first == 5 && winningStatistic.second -> 2
                winningStatistic.first == 5 -> 3
                winningStatistic.first == 4 -> 4
                winningStatistic.first == 3 -> 5
                else -> 0
            }
            winningRanks[winningRank] += 1
        }
        return winningRanks
    }

    fun getRateOfReturn(purchaseAmount: Int, winningRanks: List<Int>) {
        var winningAmount = 0.0

        for (winningRank in 1..5) {
            winningAmount += calculateWinningAmount(winningRank, winningRanks[winningRank])
        }
        val rateOfReturn = (winningAmount / purchaseAmount) * 100
        outputView.printRateOfReturn(rateOfReturn)
    }

    fun calculateWinningAmount(winningRank: Int, numberOfWinningRank: Int): Int {
        return when (winningRank) {
            1 -> FIRST_PRIZE_AMOUNT * numberOfWinningRank
            2 -> SECOND_PRIZE_AMOUNT * numberOfWinningRank
            3 -> THIRD_PRIZE_AMOUNT * numberOfWinningRank
            4 -> FOURTH_PRIZE_AMOUNT * numberOfWinningRank
            5 -> FIFTH_PRIZE_AMOUNT * numberOfWinningRank
            else -> 0
        }
    }
}