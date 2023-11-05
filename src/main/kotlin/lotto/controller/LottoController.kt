package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import util.NumberConstants.FIFTH_RANK
import util.NumberConstants.FIFTH_PRIZE_AMOUNT
import util.NumberConstants.FIRST_RANK
import util.NumberConstants.FIRST_PRIZE_AMOUNT
import util.NumberConstants.FOURTH_RANK
import util.NumberConstants.FOURTH_PRIZE_AMOUNT
import util.NumberConstants.LOTTO_AMOUNT_UNIT
import util.NumberConstants.LOTTO_MAX_NUMBER
import util.NumberConstants.LOTTO_MIN_NUMBER
import util.NumberConstants.LOTTO_TOTAL_NUMBER
import util.NumberConstants.NO_RANK
import util.NumberConstants.NO_PRIZE_AMOUNT
import util.NumberConstants.SECOND_RANK
import util.NumberConstants.SECOND_PRIZE_AMOUNT
import util.NumberConstants.THIRD_RANK
import util.NumberConstants.THIRD_PRIZE_AMOUNT

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = makeLottos(getNumberOfPurchase(purchaseAmount))
        purchaseLottos(lottos)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        val winningRanks = getWinningRanks(lottos, winningNumbers, bonusNumber)
        getWinningStatistics(winningRanks)
        getRateOfReturn(purchaseAmount, getTotalWinningAmount(winningRanks))
    }

    fun getPurchaseAmount(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            inputView.inputPurchaseAmount()
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
        return List(numberOfPurchase) { Lotto(generateLottoNumbers()) }
    }

    fun purchaseLottos(lottos: List<Lotto>) {
        outputView.printNumberOfPurchases(lottos.size)
        lottos.forEach { lotto -> outputView.printLotto(lotto) }
    }

    fun getWinningNumbers(): List<Int> {
        outputView.printWinningNumbersInstruction()
        return try {
            inputView.inputWinningNumbers()
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        outputView.printBonusNumberInstruction()
        return try {
            inputView.inputBonusNumber(winningNumbers)
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getBonusNumber(winningNumbers)
        }
    }

    fun getMatchedNumbers(lotto: Lotto, winningNumbers: List<Int>): Int {
        return lotto.getNumbers().intersect(winningNumbers).size
    }

    fun getBonusMatched(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }

    fun getWinningRanks(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): List<Int> {
        val winningRanks = MutableList(6) { 0 }
        lottos.forEach { lotto ->
            val matchedNumbers = getMatchedNumbers(lotto, winningNumbers)
            val bonusMatched = getBonusMatched(lotto, bonusNumber)
            val winningRank = judgeWinningRank(Pair(matchedNumbers, bonusMatched))
            winningRanks[winningRank] += 1
        }
        return winningRanks
    }

    fun judgeWinningRank(winningStatistic: Pair<Int, Boolean>): Int {
        return when {
            winningStatistic.first == 6 -> FIRST_RANK
            winningStatistic.first == 5 && winningStatistic.second -> SECOND_RANK
            winningStatistic.first == 5 -> THIRD_RANK
            winningStatistic.first == 4 -> FOURTH_RANK
            winningStatistic.first == 3 -> FIFTH_RANK
            else -> NO_RANK
        }
    }

    fun getWinningStatistics(winningRanks: List<Int>) {
        outputView.printWinningStatisticsInstruction()
        outputView.printWinningStatistics(winningRanks)
    }

    fun getRateOfReturn(purchaseAmount: Int, totalWinningAmount: Int) {
        val rateOfReturn = (totalWinningAmount * 100.0 / purchaseAmount)
        outputView.printRateOfReturn(rateOfReturn)
    }

    fun getTotalWinningAmount(winningRanks: List<Int>): Int {
        val totalWinningAmount = (FIRST_RANK..FIFTH_RANK).sumOf { winningRank ->
            calculateWinningAmount(winningRank, winningRanks[winningRank])
        }
        return totalWinningAmount
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