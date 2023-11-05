package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.FIFTH_RANK
import util.Constants.FIFTH_PRIZE_AMOUNT
import util.Constants.FIRST_RANK
import util.Constants.FIRST_PRIZE_AMOUNT
import util.Constants.FOURTH_RANK
import util.Constants.FOURTH_PRIZE_AMOUNT
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Constants.LOTTO_MAX_NUMBER
import util.Constants.LOTTO_MIN_NUMBER
import util.Constants.LOTTO_TOTAL_NUMBER
import util.Constants.NO_RANK
import util.Constants.NO_PRIZE_AMOUNT
import util.Constants.SECOND_RANK
import util.Constants.SECOND_PRIZE_AMOUNT
import util.Constants.THIRD_RANK
import util.Constants.THIRD_PRIZE_AMOUNT

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        var purchaseAmount: Int
        var winningNumbers: List<Int>
        var bonusNumber: Int

        while (true) {
            try {
                outputView.printPurchaseAmountInstruction()
                purchaseAmount = inputView.inputPurchaseAmount()
                break
            } catch (illegalArgumentException: IllegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.message.toString())
            }
        }

        val numberOfPurchase = getNumberOfPurchase(purchaseAmount)
        val lottos: List<Lotto> = makeLottos(numberOfPurchase)
        outputView.printNumberOfPurchases(lottos.size)
        lottos.forEach { lotto -> outputView.printLotto(lotto) }

        while (true) {
            try {
                outputView.printWinningNumbersInstruction()
                winningNumbers = inputView.inputWinningNumbers()
                break
            } catch (illegalArgumentException: IllegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.message.toString())
            }
        }

        while (true) {
            try {
                outputView.printBonusNumberInstruction()
                bonusNumber = inputView.inputBonusNumber(winningNumbers)
                break
            } catch (illegalArgumentException: IllegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.message.toString())
            }
        }

        val winningStatistics = getWinningStatistics(lottos, winningNumbers, bonusNumber)
        outputView.printWinningStatisticsInstruction()
        outputView.printWinningStatistics(winningStatistics)

        val totalWinningAmount = getTotalWinningAmount(winningStatistics)
        val rateOfReturn = getRateOfReturn(purchaseAmount, totalWinningAmount)
        outputView.printRateOfReturn(rateOfReturn)
    }

    fun getNumberOfPurchase(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_AMOUNT_UNIT
    }

    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_TOTAL_NUMBER)
    }

    fun makeLottos(numberOfPurchase: Int): List<Lotto> {
        return List(numberOfPurchase) { Lotto(generateLottoNumbers()) }
    }

    fun getMatchedNumbers(lotto: Lotto, winningNumbers: List<Int>): Int {
        return lotto.getNumbers().intersect(winningNumbers).size
    }

    fun getBonusMatched(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }

    fun judgeWinningRank(matchedNumbers: Int, bonusMatched: Boolean): Int {
        return when {
            matchedNumbers == 6 -> FIRST_RANK
            matchedNumbers == 5 && bonusMatched -> SECOND_RANK
            matchedNumbers == 5 -> THIRD_RANK
            matchedNumbers == 4 -> FOURTH_RANK
            matchedNumbers == 3 -> FIFTH_RANK
            else -> NO_RANK
        }
    }

    fun getWinningStatistics(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): List<Int> {
        val winningStatistics = MutableList(6) { 0 }
        lottos.forEach { lotto ->
            val matchedNumbers = getMatchedNumbers(lotto, winningNumbers)
            val bonusMatched = getBonusMatched(lotto, bonusNumber)
            val winningRank = judgeWinningRank(matchedNumbers, bonusMatched)
            winningStatistics[winningRank] += 1
        }
        return winningStatistics
    }

    fun getRateOfReturn(purchaseAmount: Int, totalWinningAmount: Int): Double {
        return (totalWinningAmount * 100.0) / purchaseAmount
    }

    fun getTotalWinningAmount(winningStatistics: List<Int>): Int {
        return (FIRST_RANK..FIFTH_RANK).sumOf { winningRank ->
            calculateWinningAmount(winningRank, winningStatistics[winningRank])
        }
    }

    fun calculateWinningAmount(winningRank: Int, numberOfWinningRank: Int): Int {
        return when (winningRank) {
            FIRST_RANK -> FIRST_PRIZE_AMOUNT
            SECOND_RANK -> SECOND_PRIZE_AMOUNT
            THIRD_RANK -> THIRD_PRIZE_AMOUNT
            FOURTH_RANK -> FOURTH_PRIZE_AMOUNT
            FIFTH_RANK -> FIFTH_PRIZE_AMOUNT
            else -> NO_PRIZE_AMOUNT
        } * numberOfWinningRank
    }
}