package lotto
import camp.nextstep.edu.missionutils.Console
fun main() {
    val purchaseAmount = getPurchaseAmount() // 구입 금액을 입력 받음
}
// 구입 번호를 입력하는 함수
fun getPurchaseAmount(): Int {
    while(true) {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine() ?: ""
    }
}
