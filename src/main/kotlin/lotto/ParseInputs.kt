package lotto

import camp.nextstep.edu.missionutils.Console

fun parseLottoPrice(): String {
    return Console.readLine()
}

fun readNormalWinningNumberLine():String{
    return Console.readLine()
}

fun readBonusNumberLine():String{
    return Console.readLine()
}

fun parseNormalWinningNumbers(input:String): List<Int> {
    val numbers = input.split(",").map { it.trim() }
    if (numbers.any { it.toIntOrNull() == null }) {
        throw IllegalArgumentException(ErrorMessages.NORMAL_NUMBER_NOT_INT)
    }
    return numbers.map{it.toInt()}
}

fun parseBonusNumber(input:String): Int {
    return input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.BONUS_NUMBER_NOT_INT)
}

fun promptLottoPrice(): Int {
    println(PromptMessages.WAITING_FOR_LOTTO_PRICE)
    while (true) {
        try {
            val digits = parseLottoPrice()
            validateLottoPriceString(digits)
            val price = digits.toIntOrNull() ?: continue
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
            val normalNumberLine = readNormalWinningNumberLine()
            val normalNumbers = parseNormalWinningNumbers(normalNumberLine)
            println(PromptMessages.WAITING_FOR_BONUS_NUMBER)
            val bonusNumberLine = readBonusNumberLine()
            val bonusNumber = parseBonusNumber(bonusNumberLine)
            val winningNumber = normalNumbers to bonusNumber
            validateWinningNumber(winningNumber)
            return winningNumber
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print the error message and repeat the loop
            println(PromptMessages.TRY_AGAIN)
        }
    }
}