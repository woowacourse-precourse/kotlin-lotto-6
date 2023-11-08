package view

import util.PrizeMessageRank

class OutputView {

    fun printErrorMessage(exception: Exception) = println(exception.message)

    fun printPurchaseAmount() = println(RequestType.ENTER_PURCHASE_AMOUNT.message)

    fun printPurchasedItemCount(count: Int) = println("\n${count}${RequestType.PURCHASED_N_ITEMS.message}")

    fun printLottoInfo(numbers: List<Int>) = println(numbers)

    fun printEnterWinningNumberMessage() = println(RequestType.ENTER_WINNING_NUMBERS.message)

    fun printEnterBonusNumberMessage() = println(RequestType.ENTER_BONUS_NUMBER.message)

    fun printResultMessage() = println(RequestType.WINNING_STATISTICS.message)

    fun printWinningStatistics(rank: Int, count: Int) {
        when (rank) {
            PrizeMessageRank.FIRST.rank -> println(PrizeMessageRank.FIRST.message.replace("result", "$count"))

            PrizeMessageRank.SECOND.rank -> println(PrizeMessageRank.SECOND.message.replace("result", "$count"))

            PrizeMessageRank.THIRD.rank -> println(PrizeMessageRank.THIRD.message.replace("result", "$count"))

            PrizeMessageRank.FOURTH.rank -> println(PrizeMessageRank.FOURTH.message.replace("result", "$count"))

            PrizeMessageRank.FIFTH.rank -> println(PrizeMessageRank.FIFTH.message.replace("result", "$count"))
        }
    }

    fun printProfitPercentage(profitPercentage: Float) =
        println(RequestType.PROFIT.message.replace("profit", String.format("%,.1f", profitPercentage)))

    private enum class RequestType(val message: String) {
        ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
        PURCHASED_N_ITEMS("개를 구매했습니다."),
        ENTER_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
        ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("\n당첨 통계\n---"),
        PROFIT("총 수익률은 profit%입니다."),
    }
}
