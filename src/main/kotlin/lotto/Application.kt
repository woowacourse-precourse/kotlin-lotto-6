package lotto
import camp.nextstep.edu.missionutils.Console
fun main() {
    val purchaseAmount = getPurchaseAmount() // 구입 금액을 입력 받음
}
// 구입 번호를 입력하는 함수
fun getPurchaseAmount(): Int {
    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine() ?: ""
            val purchaseAmount = input.toIntOrNull()
            if (purchaseAmount == null) { throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.") }
            if (purchaseAmount <= 0) { throw IllegalArgumentException("[ERROR] 구입 금액은 1 이상이어야 합니다.") }
            if (purchaseAmount % 1000 != 0) { throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.") }
            return purchaseAmount
        }catch (e: IllegalArgumentException) { println(e.message) }
    }
}