package lotto

import camp.nextstep.edu.missionutils.Console

class LottoManager {
    fun askPurchaseTickets(): String {
        println(Constants.Strings.ASK_LOTTO_PURCHASE_PRICE.message)
        val price = Console.readLine()

        return price
    }

    fun calculateTickets(price: Int): Int = price / 1_000
}