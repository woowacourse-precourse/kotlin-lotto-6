package ui

import camp.nextstep.edu.missionutils.Console
import util.Constants.MSG_ERR_INVALIDATE_INPUT
import util.Constants.MSG_ERR_LOTTO_NUMBER_BY_COMMA
import util.Constants.MSG_INPUT_BONUS_NUMBER
import util.Constants.MSG_INPUT_MONEY
import util.Constants.MSG_INPUT_WIN_NUMBERS
import util.Validator


object UserInput {
    private lateinit var duplicateNumbers: List<Int> // 당첨 번호들을 담아 두기 위한 변수(보너스 번호 중복 체크 용도)

    private fun readOnlyDigitAndToInt(): Int {
            val input = Console.readLine()
            Validator
                .checkIsDigit(input)
                .checkIsEmptyString(input)

            return input.toInt()
        }

    fun readMoney(): Int {
        while (true) {
            try {
                println(MSG_INPUT_MONEY)
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
        while (true) {
            try {
                println(MSG_INPUT_WIN_NUMBERS)
                val winNumbers = inputToNumbersByComma(Console.readLine())
                Validator
                    .checkProperNumbersSize(winNumbers)
                    .checkNumberListInRange(winNumbers)
                duplicateNumbers = winNumbers // 입력 받은 당첨 번호를 중복 숫자 리스트에 담는다.(보너스 번호 중복 체크 용도)

                return winNumbers
            } catch (e: NumberFormatException) {
                println(MSG_ERR_INVALIDATE_INPUT)
            } catch (e: IllegalArgumentException) {
                println(e.message + " " + MSG_ERR_LOTTO_NUMBER_BY_COMMA)
            }
        }
    }

    fun readBonusNumber(): Int {
        while (true) {
            try {
                println(MSG_INPUT_BONUS_NUMBER)
                val bonus = readOnlyDigitAndToInt()
                Validator
                    .checkNumberInRange(bonus)
                    .checkIsDuplicateNumber(bonus, duplicateNumbers)

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
            .filter { it.isNotBlank() || it.isNotEmpty() }
            .map {
                val digit = it.trim()
                Validator
                    .checkIsDigit(digit)
                    .checkIsEmptyString(digit)
                digit.toInt()
            }.distinct()
    }
}


