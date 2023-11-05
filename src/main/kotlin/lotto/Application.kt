package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var MONEY: Int? = null
val LOTTOES = mutableListOf<Lotto>()
val NUMBERS = mutableSetOf<Int>()

fun main() {
    while (MONEY == null) {
        inputMoney()
    }
    makeLottoes()
    while (NUMBERS.size != 6) {
        inputNumbers()
    }
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
    for (i in 0 until (MONEY!! / 1000)) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lotto = Lotto(numbers)
        LOTTOES.add(lotto)
    }
    showLottoes()
    println()
}

fun showLottoes() {
    for (item in LOTTOES) {
        println(item.numberList)
    }
}

fun inputNumbers() {
    NUMBERS.clear()
    println("당첨 번호를 입력해 주세요.")
    val input = Console.readLine()
    try {
        val numbers = input.split(',').toSet()
        checkNumbersFirst(numbers)
        println()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun checkNumbersFirst(numbers: Set<String>) {
    // 당첨번호가 서로 겹치지 않는지 확인
    if (numbers.size != 6) {
        throwErrorMessage("당첨번호는 겹치지 않는 번호 6개여야 합니다!")
    }

    numbers.map { number ->
        checkNumbersSecond(number)
    }
}

fun checkNumbersSecond(number: String) {
    // 당첨번호가 1~45 사이인지 확인
    if (number.toIntOrNull() == null || number.toInt() !in 1..45) {
        throwErrorMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    NUMBERS.add(number.toInt())
}

fun throwErrorMessage(text: String) {
    throw IllegalArgumentException("[ERROR] $text")
}