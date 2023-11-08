package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.enumeration.Buy
import lotto.enumeration.Winning

class LottoUI {
    fun printBuyPrice() {
        println(Buy.PRICE_INPUT.value)
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

    fun checkInvalidBuyPrice(buyPrice: String) {
        when {
            buyPrice.toIntOrNull() == null -> throw IllegalArgumentException(Buy.ERROR_NOT_INTEGER.value)
            buyPrice.toInt() % 1000 != 0 -> throw IllegalArgumentException(Buy.ERROR_NOT_THOUSAND.value)
            buyPrice.toInt() == 0 -> throw IllegalArgumentException(Buy.ERROR_NOT_THOUSAND.value)
        }
    }

    fun printBuyLottoCount(buyPrice: String) {
        println()
        print(buyPrice.toInt() / 1000)
        println(Buy.HOW_MANY.value)
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach {
            println("${it.getNumbers()}")
        }
        println()
    }

    fun printWinningNumbers() {
        println(Winning.NUMBER_INPUT.value)
    }

    fun inputWinningNumbers(): Lotto {
        val winningNumbers = Console.readLine().split(",")
        try {
            checkInvalidWinningNumbers(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            printWinningNumbers()
            return inputWinningNumbers()
        }
        return Lotto(winningNumbersToInt(winningNumbers))
    }

}
