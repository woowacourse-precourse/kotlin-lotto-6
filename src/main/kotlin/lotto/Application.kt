package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

}

fun inputMessage(): String? {
    return Console.readLine()
}

fun printStartMessage() {
    println("구입금액을 입력해 주세요.")
}

fun printPurchaseTotal(n: Int) {
    println("${n}개를 구매했습니다.")
}

fun printWinningMessage() {
    println("당첨 번호를 입력해 주세요.")
}

fun printBonusMessage() {
    println("보너스 번호를 입력해 주세요.")
}

fun printWinningReport() {
    println("당첨 통계")
    println("---")
}