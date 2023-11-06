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


}