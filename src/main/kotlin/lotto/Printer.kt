package lotto

class Printer {

    fun printEnterPurchase() = println(Message.ENTER_PURCHASE)

    fun printBuyNPieces() = println(Message.BOUGHT_N_PIECES)

    fun printEnterLottoNumber() = println(Message.ENTER_USER_PICK_NUMBERS)

    fun printLottoNumber(lottery: List<Lotto>) {
        repeat(lottery.size) {
            println(lottery[it].formatNumbers())
        }
    }


}