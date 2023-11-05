package lotto.view

import lotto.model.Lotto
import util.Constants.FIFTH_RANK
import util.Constants.FIRST_RANK
import util.Constants.FOURTH_RANK
import util.Constants.SECOND_RANK
import util.Constants.THIRD_RANK
import util.OutputMessage.BONUS_NUMBER_INSTRUCTION
import util.OutputMessage.ERROR_MESSAGE
import util.OutputMessage.NUMBER_OF_PURCHASES
import util.OutputMessage.PURCHASE_AMOUNT_INSTRUCTION
import util.OutputMessage.RATE_OF_RETURN
import util.OutputMessage.WINNING_FIFTH_RANK
import util.OutputMessage.WINNING_FIRST_RANK
import util.OutputMessage.WINNING_FOURTH_RANK
import util.OutputMessage.WINNING_NUMBER_INSTRUCTION
import util.OutputMessage.WINNING_SECOND_RANK
import util.OutputMessage.WINNING_STATISTICS_INSTRUCTION
import util.OutputMessage.WINNING_THIRD_RANK

class OutputView {
    fun printPurchaseAmountInstruction() {
        println(PURCHASE_AMOUNT_INSTRUCTION.message)
    }

    fun printErrorMessage(errorMessage: String) {
        println(ERROR_MESSAGE.message.format(errorMessage))
    }

    fun printNumberOfPurchases(numberOfPurchase: Int) {
        println(NUMBER_OF_PURCHASES.message.format(numberOfPurchase))
    }

    fun printLotto(lotto: Lotto) {
        println(lotto)
    }

    fun printWinningNumbersInstruction() {
        println(WINNING_NUMBER_INSTRUCTION.message)
    }

    fun printBonusNumberInstruction() {
        println(BONUS_NUMBER_INSTRUCTION.message)
    }

    fun printWinningStatisticsInstruction() {
        println(WINNING_STATISTICS_INSTRUCTION.message)
    }

    fun printWinningStatistics(winningStatistics: List<Int>) {
        println(WINNING_FIFTH_RANK.message.format(winningStatistics[FIFTH_RANK]))
        println(WINNING_FOURTH_RANK.message.format(winningStatistics[FOURTH_RANK]))
        println(WINNING_THIRD_RANK.message.format(winningStatistics[THIRD_RANK]))
        println(WINNING_SECOND_RANK.message.format(winningStatistics[SECOND_RANK]))
        println(WINNING_FIRST_RANK.message.format(winningStatistics[FIRST_RANK]))
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println(RATE_OF_RETURN.message.format(rateOfReturn))
    }
}