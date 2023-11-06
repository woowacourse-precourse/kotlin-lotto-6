package lotto.domain

import lotto.constants.*

fun moneyErrorCheck(moneyInput : String){
    blankCheck(moneyInput)
    numberCheck(moneyInput)
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
    if (money % 1000 != 0) {
        throw IllegalArgumentException(MONEY_ERROR)
    }
}

fun winningNumberErrorCheck(input: String, splitInput: List<String>): List<Int> {
    winBlankCheck(splitInput)
    winNumberCheck(splitInput)
    winNumberIndexCheck(splitInput)
    val changeNumbers = input.split(",").map { it.toInt() }
    winChangeNumberCheck(changeNumbers)
    winValidNumberCheck(changeNumbers)
    return changeNumbers.filter { it in 1..45 }
}

fun winNumberCheck(splitInput: List<String>) {
    splitInput.forEach {
        runCatching { it.toInt() }
            .onFailure { throw IllegalArgumentException(NUMBER_ERROR) }
    }
}

fun winBlankCheck(splitInput: List<String>) {
    for(i in splitInput){
        if(i==""){
            throw IllegalArgumentException(BLANK_ERROR)
        }
    }
}

fun winNumberIndexCheck(splitInput: List<String>) {
    if (splitInput.size != 6) {
        throw IllegalArgumentException(INDEX_ERROR)
    }
}

fun winValidNumberCheck(changeNumbers: List<Int>) {
    val validNumber= changeNumbers.filter { it in 1..45 }
    if (validNumber.size != 6) {
        throw IllegalArgumentException(RANGE_ERROR)

    }
}

fun winChangeNumberCheck(changeNumbers: List<Int>) {
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
    if (bonus.equals("")) {
        throw IllegalArgumentException(BLANK_ERROR)
    }
}

fun bonusRangeCheck(bonusNumber: Int) {
    if (bonusNumber < 1 || bonusNumber > 45) {
        throw IllegalArgumentException(RANGE_ERROR)
    }
}

fun bonusWinningDuplicateCheck(winningNumber: List<Int>, bonusNumber: Int) {
    if (bonusNumber in winningNumber) {
        throw IllegalArgumentException(DUPLICATE_ERROR)
    }
}

fun bonusNumberCheck(bonus: String){
    if(bonus.toIntOrNull()==null){
        throw IllegalArgumentException(NUMBER_ERROR)
    }
}
