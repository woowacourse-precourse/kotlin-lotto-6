package ui

import camp.nextstep.edu.missionutils.Console
import util.Constants.MSG_INPUT_BONUS_NUMBER
import util.Constants.MSG_INPUT_MONEY
import util.Constants.MSG_INPUT_WIN_NUMBERS
import util.Validator



object UserInput {

    private fun readOnlyDigit(): String {
        val input = Console.readLine()
        Validator
            .checkIsDigit(input)
            .checkIsEmptyString(input)

        return input
    }

    fun readMoney(): Int {
        println(MSG_INPUT_MONEY)
        val money = readOnlyDigit().toInt()
        Validator.checkPurchaseRange(money)

        return money
    }

    fun readWinNumbers(): List<Int> {
        println(MSG_INPUT_WIN_NUMBERS)
        val winNumbers = inputToNumbersByComma(Console.readLine())
        Validator
            .checkProperNumbersSize(winNumbers)
            .checkNumberListInRange(winNumbers)

        return winNumbers
    }

    fun readBonusNumber(): Int {
        println(MSG_INPUT_BONUS_NUMBER)
        val bonus = readOnlyDigit().toInt()
        Validator.checkNumberInRange(bonus)

        return bonus
    }
}

private fun inputToNumbersByComma(input: String): List<Int> {
    return input.split(",")
        .map {
            val digit = it.trim()
            Validator
                .checkIsDigit(digit)
                .checkIsEmptyString(digit)
            digit.toInt()
        }.distinct()
}


