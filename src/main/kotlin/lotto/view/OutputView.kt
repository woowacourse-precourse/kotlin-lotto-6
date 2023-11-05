package lotto.view

import lotto.model.Lotto
import util.NumberConstants.FIFTH_RANK
import util.NumberConstants.FIRST_RANK
import util.NumberConstants.FOURTH_RANK
import util.NumberConstants.SECOND_RANK
import util.NumberConstants.THIRD_RANK
import util.StringConstants.BONUS_NUMBER_INSTRUCTION
import util.StringConstants.ERROR_MESSAGE
import util.StringConstants.NUMBER_OF_PURCHASES
import util.StringConstants.PURCHASE_AMOUNT_INSTRUCTION
import util.StringConstants.RATE_OF_RETURN
import util.StringConstants.WINNING_FIFTH_RANK
import util.StringConstants.WINNING_FIRST_RANK
import util.StringConstants.WINNING_FOURTH_RANK
import util.StringConstants.WINNING_NUMBER_INSTRUCTION
import util.StringConstants.WINNING_SECOND_RANK
import util.StringConstants.WINNING_STATISTICS_INSTRUCTION
import util.StringConstants.WINNING_THIRD_RANK

class OutputView {
    fun printPurchaseAmountInstruction() {
        println(PURCHASE_AMOUNT_INSTRUCTION)
    }

    fun printErrorMessage(errorMessage: String) {
        println(ERROR_MESSAGE.format(errorMessage))
    }

    fun printNumberOfPurchases(numberOfPurchase: Int) {
        println(NUMBER_OF_PURCHASES.format(numberOfPurchase))
    }

    fun printLotto(lotto: Lotto) {
        println(lotto)
    }

    fun printWinningNumbersInstruction() {
        println(WINNING_NUMBER_INSTRUCTION)
    }

    fun printBonusNumberInstruction() {
        println(BONUS_NUMBER_INSTRUCTION)
    }

    fun printWinningStatisticsInstruction() {
        println(WINNING_STATISTICS_INSTRUCTION)
    }

    fun printWinningStatistics(winningRanks: List<Int>) {
        println(WINNING_FIFTH_RANK.format(winningRanks[FIFTH_RANK]))
        println(WINNING_FOURTH_RANK.format(winningRanks[FOURTH_RANK]))
        println(WINNING_THIRD_RANK.format(winningRanks[THIRD_RANK]))
        println(WINNING_SECOND_RANK.format(winningRanks[SECOND_RANK]))
        println(WINNING_FIRST_RANK.format(winningRanks[FIRST_RANK]))
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println(RATE_OF_RETURN.format(rateOfReturn))
    }
}