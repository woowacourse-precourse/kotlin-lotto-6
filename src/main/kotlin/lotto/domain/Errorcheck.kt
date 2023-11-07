package lotto.domain

import lotto.constants.*

fun moneyErrorCheck(moneyInput: String) {
    blankCheck(moneyInput)
    numberCheck(moneyInput)
    moneyNegativeCheck(moneyInput.toInt())
    moneyCheck(moneyInput.toInt())
}

fun blankCheck(input: String) {
    if (input.isBlank()) {
        throw IllegalArgumentException(BLANK_ERROR)
    }
}

fun numberCheck(input: String) {
    if (input.toIntOrNull() == null) {
        throw IllegalArgumentException(NUMBER_ERROR)
    }
}

fun moneyCheck(money: Int) {
    if (money % MONEY_UNIT != 0) {
        throw IllegalArgumentException(MONEY_ERROR)
    }
}

fun moneyNegativeCheck(money: Int) {
    if (money < 0) {
        throw IllegalArgumentException(NEGATIVE_ERROR)
    }
}

fun winningNumberErrorCheck(input: String, splitInput: List<String>): List<Int> {
    winBlankCheck(splitInput)
    winNumberCheck(splitInput)
    winNumberIndexCheck(splitInput)
    val changeNumbers = input.split(",").map { it.toInt() }
    winNumberDistinctCheck(changeNumbers)
    winNumberRangeCheck(changeNumbers)
    return changeNumbers.filter { it in RANGE_MIN..RANGE_MAX }
}

fun winNumberCheck(splitInput: List<String>) {
    for (input in splitInput) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(NUMBER_ERROR)
        }
    }
}

fun winBlankCheck(splitInput: List<String>) {
    for (i in splitInput) {
        if (i == "") {
            throw IllegalArgumentException(BLANK_ERROR)
        }
    }
}

fun winNumberIndexCheck(splitInput: List<String>) {
    if (splitInput.size != NUMBER_SIZE) {
        throw IllegalArgumentException(INDEX_ERROR)
    }
}

fun winNumberRangeCheck(changeNumbers: List<Int>) {
    val validNumber = changeNumbers.filter { it in RANGE_MIN..RANGE_MAX }
    if (validNumber.size != NUMBER_SIZE) {
        throw IllegalArgumentException(RANGE_ERROR)

    }
}

fun winNumberDistinctCheck(changeNumbers: List<Int>) {
    if (changeNumbers.distinct().size != changeNumbers.size) {
        throw IllegalArgumentException(DUPLICATE_ERROR)
    }
}


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
