package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    println("구입금액을 입력해 주세요.")
    val purchaseAmount = readPurchaseAmount()
    println()

}

fun readPurchaseAmount(): Int {
    while (true) {
        try {
            val input = Console.readLine().toInt()
            if (input % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 유효한 금액을 입력하세요.")
            }
            return input
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효한 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

