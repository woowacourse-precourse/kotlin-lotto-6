package ui

import camp.nextstep.edu.missionutils.Console
import util.Constants.MSG_ERR_INVALIDATE_INPUT
import util.Constants.MSG_INPUT_BONUS_NUMBER
import util.Constants.MSG_INPUT_MONEY
import util.Constants.MSG_INPUT_WIN_NUMBERS
import util.Validator


object UserInput {

    private fun readOnlyDigitAndToInt(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                Validator
                    .checkIsDigit(input)
                    .checkIsEmptyString(input)

                return input.toInt()
            } catch (ne: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    fun readMoney(): Int {
        println(MSG_INPUT_MONEY)
        while (true) {
            try {
                val money = readOnlyDigitAndToInt()
                Validator.checkPurchaseRange(money)
                Validator.checkIsDivisibleByThousand(money)
                return money
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    fun readWinNumbers(): List<Int> {
        println(MSG_INPUT_WIN_NUMBERS)
        while (true) {
            try {
                val winNumbers = inputToNumbersByComma(Console.readLine())
                Validator
                    .checkProperNumbersSize(winNumbers)
                    .checkNumberListInRange(winNumbers)

                return winNumbers
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(): Int {
        println(MSG_INPUT_BONUS_NUMBER)
        while (true) {
            try {
                val bonus = readOnlyDigitAndToInt()
                Validator.checkNumberInRange(bonus)

                return bonus
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
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
}


