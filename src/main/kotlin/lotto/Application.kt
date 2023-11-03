package lotto
import camp.nextstep.edu.missionutils.Console

fun main() {
    var amount = 0
    while (true) {
        println("구입금액을 입력해주세요.")
        val purchaseAmount = Console.readLine()

        try {
            amount = purchaseAmount.toInt()

            if (amount < 1000) {
                throw IllegalArgumentException("[ERROR] 1000 이상의 금액을 입력하세요.")
            } else if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 값을 입력하세요.")
            } else {
                break // Break out of the loop when valid input is provided
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

}
