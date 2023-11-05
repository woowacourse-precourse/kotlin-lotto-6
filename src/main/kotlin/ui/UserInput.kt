package ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_MONEY = "구입금액을 입력해 주세요."

const val MAX_PURCHASE_MONEY = 100_000
const val MIN_PURCHASE_MONEY = 1000

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
}

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
}
