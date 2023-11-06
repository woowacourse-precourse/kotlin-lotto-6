package lotto

import java.lang.IllegalArgumentException

object InputValidator {

    fun checkIsNotBlank(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(Constants.ERROR_BLANK_MESSAGE)
    }

    fun checkIsDigit(input: String) {
        if (input.map { Character.isDigit(it) }.contains(false))
            throw IllegalArgumentException(Constants.ERROR_FORMAT_MESSAGE)
    }

    fun checkDividedAsThousand(input: String) {
        if (input.toInt() % 1000 != 0) throw IllegalArgumentException(Constants.ERROR_FORMAT_MESSAGE)
    }

    fun checkIsOverZero(input: String) {
        if (input.toInt() <= 0) throw IllegalArgumentException(Constants.ERROR_FORMAT_MESSAGE)
    }

    fun checkIsInBoundary(number: Int, minNumber: Int, maxNumber: Int) {
        if (number !in minNumber..maxNumber) throw IllegalArgumentException(Constants.ERROR_BOUNDARY_MESSAGE)
    }

    fun checkHasSeparator(input: String, separator: String) {
        if (!input.contains(separator)) throw IllegalArgumentException(Constants.ERROR_SEPARATOR_MESSAGE)
    }

    fun <T> checkCountsOf(items: List<T>, count: Int) {
        if (items.size != count) throw IllegalArgumentException(Constants.ERROR_COUNT_MESSAGE)
    }

    fun <T> checkIsNotContained(input: T, items: List<T>) {
        if (items.contains(input)) throw IllegalArgumentException(Constants.ERROR_DISTINCTION_MESSAGE)
    }
}