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

    private fun checkInvalidBuyPrice(buyPrice: String) {
        when {
            buyPrice.toIntOrNull() == null -> throw IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.")
            buyPrice.toInt() % 1000 != 0 -> throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
        }
    }

}
