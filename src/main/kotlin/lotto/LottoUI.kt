package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.enumeration.PrintBuy

class LottoUI {
    fun printBuyPrice() {
        println(PrintBuy.PRICE.value)
    }

    fun inputBuyPrice(): String {
        val buyPrice = Console.readLine()
        try {
            checkInvalidBuyPrice(buyPrice)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            printBuyPrice()
            return inputBuyPrice()
        }
        return buyPrice
    }

}
