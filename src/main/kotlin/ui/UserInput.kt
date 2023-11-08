package ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_MONEY = "구입금액을 입력해 주세요."
const val MSG_INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요."
const val MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
const val MSG_INPUT_LOTTO_NUMBER_BY_COMMA = "숫자가 여러 개인 경우 쉼표(,)로 구분해주세요. 예) 1,2,3,4,5,6"

object UserInput {

    private fun readOnlyDigitAndToInt(): Int {
        val input = Console.readLine()
        InputValidator
            .checkIsDigit(input)
            .checkIsEmptyString(input)

        return input.toInt()
    }

    fun readMoney(): Int {
        while (true) {
            try {
                println(MSG_INPUT_MONEY)
                val money = readOnlyDigitAndToInt()
                InputValidator.checkPurchaseRange(money)
                InputValidator.checkIsDivisibleByThousand(money)
                return money
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    fun readWinNumbers(): List<Int> {
        while (true) {
            try {
                println(MSG_INPUT_WIN_NUMBERS)
                val winNumbers = inputToNumbersByDelimiter(Console.readLine(), ",")
                InputValidator
                    .checkProperNumbersSize(winNumbers)
                    .checkNumberListInRange(winNumbers)

                return winNumbers
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message + " " + MSG_INPUT_LOTTO_NUMBER_BY_COMMA)
            }
        }
    }

    fun readBonusNumber(existingNumbers: List<Int>): Int {
        while (true) {
            try {
                println(MSG_INPUT_BONUS_NUMBER)
                val bonus = readOnlyDigitAndToInt()
                InputValidator
                    .checkNumberInRange(bonus)
                    .checkIsExistingNumber(bonus, existingNumbers)

                return bonus
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputToNumbersByDelimiter(input: String, delimiter: String): List<Int> {
        return input.split(delimiter)
            .map {
                val digit = it.trim()
                InputValidator
                    .checkIsDigit(digit)
                    .checkIsEmptyString(digit)
                digit.toInt()
            }.distinct()
    }
}


