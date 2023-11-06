package lotto

class Printer {

    fun printEnterPurchaseAnnouncement() = println(Message.ENTER_PURCHASE)

    fun printBuyNPiecesAnnouncement() = println(Message.BOUGHT_N_PIECES)

    fun printEnterUserPickNumbersAnnouncement() = println(Message.ENTER_USER_PICK_NUMBERS)

    fun printEnterBonusNumberAnnouncement() = println(Message.ENTER_BONUS_NUMBER)

    fun printWinningStatisticsAnnouncement() = println(Message.WINNING_STATISTICS)

    fun printCommaAnnouncement() = println(Message.COMMA)

    fun printLottoNumber(lottery: List<Lotto>) {
        repeat(lottery.size) {
            println(lottery[it].formatNumbers())
        }
    }

    fun printWinningStatistics(types: List<LottoWinType>, yield: String) {
        for (winType in LottoWinType.entries) {
            val count = types.count { it == winType }
            println("${winType.description} ( ${winType.prize}원) - ${count}개")
        }
        println("총 수익률은 ${yield}입니다.")
    }

}