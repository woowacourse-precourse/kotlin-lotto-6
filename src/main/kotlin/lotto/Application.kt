package lotto
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해주세요.")
    var purchaseAmount = Console.readLine()

    try {
        purchaseAmount.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
    }

}
