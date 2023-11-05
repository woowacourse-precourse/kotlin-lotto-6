package ui

import camp.nextstep.edu.missionutils.Console
import util.Constants.MSG_INPUT_MONEY
import util.Constants.MSG_INPUT_WIN_NUMBERS
import util.Validator



object UserInput {

    fun readMoney(): Int {
        println(MSG_INPUT_MONEY)
        val input = Console.readLine()
        Validator
            .checkIsDigit(input)
            .checkIsEmptyString(input)

        val money = input.toInt()
        Validator.checkPurchaseRange(money)

        return money
    }

    fun readWinNumbers(): List<Int> {
        println(MSG_INPUT_WIN_NUMBERS)
        val input = Console.readLine()
        Validator
            .checkIsDigit(input)
            .checkIsEmptyString(input)

        val winNumbers = inputToNumbersByComma(input)
        Validator.checkProperNumbersSize(winNumbers)

        return winNumbers
    }
}

private fun inputToNumbersByComma(input: String) =
    input.split(",")
        .map { it.toInt() }
        .distinct()
