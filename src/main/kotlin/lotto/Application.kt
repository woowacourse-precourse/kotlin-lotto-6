package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        printStartMessage()
        val input = inputMessage().trim()
        val result = purchaseAmountEmpty(input)

        printPurchaseTotal(result)

//        repeat(result/1000) {
//            lottoSort(makeLotto())
//        }
        var lotto = lottoSort(makeLotto())
        printWinningMessage()
        val winningNumber = inputMessage().trim()
        val winningResult = parser(winningNumber)

        printBonusMessage()
        val BonusNumber = inputMessage().trim()

        printWinningReport()

        compareToLotto(lotto, winningResult)


    } catch (e: IllegalArgumentException) {
        println(e.message)
        main()
    }

}

fun inputMessage(): String {
    return Console.readLine()
}

fun printStartMessage() {
    println("구입금액을 입력해 주세요.")
}

fun printPurchaseTotal(n: Int) {
    println("${n/1000}개를 구매했습니다.")
}

fun printWinningMessage() {
    println("당첨 번호를 입력해 주세요.")
}

fun printBonusMessage() {
    println("보너스 번호를 입력해 주세요.")
}

fun printWinningReport() {
    println("당첨 통계\n---")
}

// Validator
// 로또 구매 금액이 정수가 아닌 경우
fun purchaseAmount(num: String): Int{
    require (num.all { it.isDigit() }) {"[ERROR] 로또 금액은 정수로 입력해주세요."}
    return num.toInt()
}
// 로또 구매 금액이 공백인 경우
fun purchaseAmountEmpty(num: String): Int {
    require (num.isNotEmpty() && num.isNotBlank()) {"[ERROR] 공백은 포함할 수 없습니다."}
    return num.toInt()
}

fun purchaseAmountEmpty(num: Int): Int {
    require (num % 1000 != 0) {"[ERROR] 1,000원 단위로 입력해주세요."}
    return num
}

fun makeLotto(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}

fun lottoSort(list: List<Int>): List<Int> {
    return list.sorted()
}

// 쉼표로 나누기, 정수로 변경
fun parser(s: String): List<Int> {
    val win = s.split(",")
    return win.map { it.toInt() }
}

// 당첨 번호와 로또 번호 비교
fun compareToLotto(lotto: List<Int>, winningResult: List<Int>) {
    val union = lotto + winningResult
    val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }
    println(intersection.size)
}