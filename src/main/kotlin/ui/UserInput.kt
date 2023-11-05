package ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_MONEY = "구입금액을 입력해 주세요."
const val MSG_INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요."
const val MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

const val MAX_PURCHASE_MONEY = 100_000
const val MIN_PURCHASE_MONEY = 1000
const val PROPER_SIZE = 6

object UserInput {

    fun readMoney(): Int {
        println(MSG_INPUT_MONEY)
        val input = Console.readLine()
        InputValidator
            .checkIsDigit(input)
            .checkIsEmptyString(input)

        val money = input.toInt()
        InputValidator.checkPurchaseRange(money)

        return money
    }

    fun readWinNumbers(): List<Int> {
        println(MSG_INPUT_WIN_NUMBERS)
        val input = Console.readLine()
        InputValidator
            .checkIsDigit(input)
            .checkIsEmptyString(input)

        val winNumbers = inputToNumbersByComma(input)
        InputValidator.checkProperNumbersSize(winNumbers)

        return winNumbers
    }
}

private fun inputToNumbersByComma(input: String) =
    input.split(",")
        .map { it.toInt() }
        .distinct()

object InputValidator {

    fun checkIsDigit(input: String): InputValidator {
        require(input.all{ it.isDigit() })
        return this
    }

    fun checkIsEmptyString(input: String): InputValidator {
        require(input.isNotEmpty())
        return this
    }

    fun checkPurchaseRange(money: Int): InputValidator {
        require(money in MIN_PURCHASE_MONEY..MAX_PURCHASE_MONEY)
        return this
    }

    fun checkProperNumbersSize(numbers: List<Int>) =
        require(
            numbers.distinct()
                .size == 6
        )
}
