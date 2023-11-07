package lotto.domain

import lotto.constants.*

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