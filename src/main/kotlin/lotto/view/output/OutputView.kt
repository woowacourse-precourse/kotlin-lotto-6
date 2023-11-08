package lotto.view.output

import lotto.constants.GameConstants
import lotto.domain.winning.model.WinningRank

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

    fun printRankStatistics(rank: WinningRank, count: Int) {
        output.printMessage("${rank.matchCount}개 일치 (${rank.prize}원) - ${count}개")
    }

    fun profitRateMessage(profitRate: Double) {
        println("${GameConstants.MESSAGE_PROFIT_RATE_START} ${String.format("%.2f", profitRate)} ${GameConstants.MESSAGE_PROFIT_RATE_END}")
    }
}
