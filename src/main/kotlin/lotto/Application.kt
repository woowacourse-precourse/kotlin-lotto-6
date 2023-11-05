package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var MONEY: Int? = null

fun main() {
    initialize()
    while (MONEY == null) {
        inputMoney()
    }
    makeLottoes()
}

fun initialize() {
    MONEY = null
}

fun inputMoney() {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()
    try {
        checkMoney(input)
        MONEY = input.toInt()
        println()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun checkMoney(tempMoney: String) {
    // Int형이거나, 1000 이상이거나, 1000으로 나누어 떨어지는지 확인
    if (tempMoney.toIntOrNull() == null || tempMoney.toInt() < 1000 || tempMoney.toInt() % 1000 != 0) {
        throwErrorMessage("1000원 이상 입력 및 1000원으로 나누어 떨어지게 하세요.")
    }
}

fun makeLottoes() {
    println("${MONEY!! / 1000}개를 구매했습니다.")
    for(i in 0 until (MONEY!! / 1000)) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers)
    }
}

fun throwErrorMessage(text: String) {
    throw IllegalArgumentException("[ERROR] $text")
}