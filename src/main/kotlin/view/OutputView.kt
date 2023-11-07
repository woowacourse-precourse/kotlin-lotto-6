package view

class OutputView {

    fun printError(exception: Exception) = println(exception.message)

    fun printPurchaseAmount() = println(RequestType.ENTER_PURCHASE_AMOUNT.message)

    fun printPurchasedItemCount(count: Int) = println("${count}${RequestType.PURCHASED_N_ITEMS.message}")

    fun printLottoInfo(numbers: List<Int>) = println(numbers)

    fun printAppendLine() = println()

    fun printEnterWinningNumberMessage() = println(RequestType.ENTER_WINNING_NUMBERS.message)

    fun printEnterBonusNumberMessage() = println(RequestType.ENTER_BONUS_NUMBER.message)

    fun printResultMessage() = println(RequestType.WINNING_STATISTICS.message)

    fun printWinningStatistics(rank: Int, count: Int) {
        when (rank) {
            RankMessage.FIRST_PRIZE.rank -> println(RankMessage.FIRST_PRIZE.message.replace("result", "$count"))

            RankMessage.SECOND_PRIZE.rank -> println(RankMessage.SECOND_PRIZE.message.replace("result", "$count"))

            RankMessage.THIRD_PRIZE.rank -> println(RankMessage.THIRD_PRIZE.message.replace("result", "$count"))

            RankMessage.FOURTH_PRIZE.rank -> println(RankMessage.FOURTH_PRIZE.message.replace("result", "$count"))

            RankMessage.FIFTH_PRIZE.rank -> println(RankMessage.FIFTH_PRIZE.message.replace("result", "$count"))
        }
    }

    fun printProfitPercentage(profitPercentage: Float) =
        println(RequestType.PROFIT.message.replace("profit", String.format("%,.1f", profitPercentage)))

    private enum class RequestType(val message: String) {
        ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
        PURCHASED_N_ITEMS("개를 구매했습니다."),
        ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("당첨 통계\n---"),
        PROFIT("총 수익률은 profit%입니다."),
    }

    private enum class RankMessage(val rank: Int, val message: String) {
        FIRST_PRIZE(1, "6개 일치 (2,000,000,000원) - result개"),
        SECOND_PRIZE(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - result개"),
        THIRD_PRIZE(3, "5개 일치 (1,500,000원) - result개"),
        FOURTH_PRIZE(4, "4개 일치 (50,000원) - result개"),
        FIFTH_PRIZE(5, "3개 일치 (5,000원) - result개"),
    }
}
