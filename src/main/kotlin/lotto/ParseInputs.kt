package lotto

import camp.nextstep.edu.missionutils.Console

fun parseLottoPrice(): String {
    return Console.readLine()
}

fun parseNormalWinningNumbers(): List<Int> {
    val input = Console.readLine()
    val numbers = input.split(",").map { it.trim() }
    if (numbers.any { it.toIntOrNull() == null }) {
        throw IllegalArgumentException("[ERROR] 당첨 번호는 정수여야 합니다.")
    }
    return numbers.map { it.toInt() }
}

fun parseBonusNumber(): Int {
    val input = Console.readLine().trim()
    return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.")
}

fun convertLottoPrice(digits: String): Int? {
    return digits.toIntOrNull()
}

fun promptLottoPrice(): Int {
    println("구입금액을 입력해주세요.")
    while (true) {
        try {
            val digits = parseLottoPrice()
            val price = convertLottoPrice(digits) ?: throw IllegalArgumentException("[ERROR] 주어진 금액이 숫자 형식이 아닙니다.")
            validateLottoPrice(price)
            return price // Successfully validated, break the loop
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print the error message and repeat the loop
            println("다시 입력해주세요.")
        }
    }
}

fun promptWinningNumber(): Pair<List<Int>, Int> {
    while (true) {
        try {
            println("당첨 번호를 입력해 주세요.")
            val normalNumbers = parseNormalWinningNumbers()
            println("보너스 번호를 입력해 주세요.")
            val bonusNumber = parseBonusNumber()
            val winningNumber = normalNumbers to bonusNumber
            validateWinningNumber(winningNumber)
            return winningNumber
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print the error message and repeat the loop
            println("다시 입력해주세요.")
        }
    }
}
