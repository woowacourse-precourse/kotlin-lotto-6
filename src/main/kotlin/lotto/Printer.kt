package lotto

class Printer {

    fun printEnterPurchaseAnnouncement() = println(Message.ENTER_PURCHASE)

    fun printBuyNPiecesAnnouncement(purchaseNumber: Int) = println("$purchaseNumber${Message.BOUGHT_N_PIECES}")

    fun printEnterUserPickNumbersAnnouncement() = println(Message.ENTER_USER_PICK_NUMBERS)

    fun printEnterBonusNumberAnnouncement() = println(Message.ENTER_BONUS_NUMBER)

    fun printWinningStatisticsAnnouncement() = println(Message.WINNING_STATISTICS)

    fun printCommaAnnouncement() = println(Message.COMMA)

    fun printRandomLottoNumbers(lottery: List<Lotto>) {
        repeat(lottery.size) {
            println(lottery[it].formatNumbers())
        }
    }

    fun printWinningStatistics(types: List<LottoWinType>, yield: String) {
        for (winType in LottoWinType.entries) {
            val formattedNumber = "%,d".format(winType.prize)
            val count = types.count { it == winType }
            println("${winType.description} (${formattedNumber}원) - ${count}개")
        }
        println("총 수익률은 ${yield}입니다.")
    }

}