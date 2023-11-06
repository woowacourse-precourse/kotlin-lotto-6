package lotto

import java.lang.IllegalArgumentException

object InputValidator {

    fun checkIsNotBlank(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(Constants.ERROR_BLANK_MESSAGE)
    }

    fun checkIsNumeric(input: String) {
        if (input.map { Character.isDigit(it) }.contains(false))
            throw IllegalArgumentException(Constants.ERROR_FORMAT_MESSAGE)
    }

    fun checkDividedAsThousand(input: String) {
        if (input.toInt() % 1000 != 0) throw IllegalArgumentException(Constants.ERROR_MONEY_FORMAT_MESSAGE)
    }

    fun checkIsNotZero(input: String) {
        if (input.toInt() == 0) throw IllegalArgumentException(Constants.ERROR_MONEY_FORMAT_MESSAGE)
    }
}