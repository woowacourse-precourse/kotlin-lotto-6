package lotto.domain

import lotto.constants.*

fun bonusNumberErrorCheck(winningNumber: List<Int>, bonus: String): Int {
    bonusBlankCheck(bonus)
    bonusNumberCheck(bonus)
    val bonusNumber = bonus.toInt()
    bonusRangeCheck(bonusNumber)
    bonusWinningDuplicateCheck(winningNumber, bonusNumber)
    return bonusNumber
}

fun bonusBlankCheck(bonus: String) {
    if (bonus == "") {
        throw IllegalArgumentException(BLANK_ERROR)
    }
}

fun bonusRangeCheck(bonusNumber: Int) {
    if (bonusNumber < RANGE_MIN || bonusNumber > RANGE_MAX) {
        throw IllegalArgumentException(RANGE_ERROR)
    }
}

fun bonusWinningDuplicateCheck(winningNumber: List<Int>, bonusNumber: Int) {
    if (bonusNumber in winningNumber) {
        throw IllegalArgumentException(DUPLICATE_ERROR)
    }
}

fun bonusNumberCheck(bonus: String) {
    if (bonus.toIntOrNull() == null) {
        throw IllegalArgumentException(NUMBER_ERROR)
    }
}