package lotto

import camp.nextstep.edu.missionutils.Console

var MONEY: Int? = null

fun main() {
    initialize()
    while (MONEY == null) {
        inputMoney()
    }
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

fun throwErrorMessage(text: String) {
    throw IllegalArgumentException("[ERROR] $text")
}