package lotto

import camp.nextstep.edu.missionutils.Console

class Ticket() {
    var numberOfLotto: Int = 0

    init {
        putPrice()
    }

    fun putPrice() {
        println("구입금액을 입력해 주세요.")
        val price = Console.readLine()
        try {
            Validator.convertNumber(price)
            Validator.price(price)
            numberOfLotto = price.toInt() / TICKET_PRICE
        } catch (e: IllegalArgumentException) {
            println(e.message)
            putPrice()
        }
    }

    companion object {
        const val TICKET_PRICE = 1000
    }

}