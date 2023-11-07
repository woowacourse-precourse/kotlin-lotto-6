package lotto.view.output

import lotto.constants.GameConstants

object OutputView {
    private val output: OutputInterface = ConsoleOutput()

    fun requestPurchaseAmountMessage() {
        output.printMessage(GameConstants.MESSAGE_REQUEST_PURCHASE_AMOUNT)
    }

    fun countLottoMessage(lottoPurchaseNumber: Int) {
        output.printMessage("${lottoPurchaseNumber}${GameConstants.MESSAGE_LOTTO_COUNT_PURCHASED}")
    }

    fun requestWinningNumbersMessage() {
        output.printMessage(GameConstants.MESSAGE_INPUT_WINNING_NUMBERS)
    }

    fun requestBonusNumberMessage() {
        output.printMessage(GameConstants.MESSAGE_INPUT_BONUS_NUMBER)
    }

    fun winningStatisticsMessage() {
        output.printMessage(GameConstants.MESSAGE_WINNING_STATISTICS)
    }

    fun matchThreeMessage() {
        output.printMessage(GameConstants.MESSAGE_MATCH_THREE)
    }

    fun matchFourMessage() {
        output.printMessage(GameConstants.MESSAGE_MATCH_FOUR)
    }

    fun matchFiveMessage() {
        output.printMessage(GameConstants.MESSAGE_MATCH_FIVE)
    }

    fun matchFiveBonusMessage() {
        output.printMessage(GameConstants.MESSAGE_MATCH_FIVE_BONUS)
    }

    fun matchSixMessage() {
        output.printMessage(GameConstants.MESSAGE_MATCH_SIX)
    }

    fun profitRateMessage() {
        output.printMessage(GameConstants.MESSAGE_PROFIT_RATE_START)
    }

    fun profitRateEndMessage() {
        output.printMessage(GameConstants.MESSAGE_PROFIT_RATE_END)
    }
}
