package lotto

import camp.nextstep.edu.missionutils.Console

fun parseLottoPrice(): String {
    return Console.readLine()
}

fun parseNormalWinningNumbers(): List<Int> {
    val input = Console.readLine()
    val numbers = input.split(",").map { it.trim() }
    if (numbers.any { it.toIntOrNull() == null }) {
        throw IllegalArgumentException(ErrorMessages.NORMAL_NUMBER_NOT_INT)
    }
    return numbers.map { it.toInt() }
}

fun parseBonusNumber(): Int {
    val input = Console.readLine().trim()
    return input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.BONUS_NUMBER_NOT_INT)
}

fun convertLottoPrice(digits: String): Int? {
    return digits.toIntOrNull()
}

fun promptLottoPrice(): Int {
    println(PromptMessages.WAITING_FOR_LOTTO_PRICE)
    while (true) {
        try {
            val digits = parseLottoPrice()
            val price = convertLottoPrice(digits) ?: throw IllegalArgumentException(ErrorMessages.PRICE_NOT_INT)
            validateLottoPrice(price)
            return price // Successfully validated, break the loop
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print the error message and repeat the loop
            println(PromptMessages.TRY_AGAIN)
        }
    }
}

fun promptWinningNumber(): Pair<List<Int>, Int> {
    while (true) {
        try {
            println(PromptMessages.WAITING_FOR_NORMAL_WINNING_NUMBER)
            val normalNumbers = parseNormalWinningNumbers()
            println(PromptMessages.WAITING_FOR_BONUS_NUMBER)
            val bonusNumber = parseBonusNumber()
            val winningNumber = normalNumbers to bonusNumber
            validateWinningNumber(winningNumber)
            return winningNumber
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print the error message and repeat the loop
            println(PromptMessages.TRY_AGAIN)
        }
    }
}