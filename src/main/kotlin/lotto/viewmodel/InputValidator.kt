package lotto.viewmodel

import lotto.model.ERROR.*

class InputValidator {
    private fun isNumber(input: String): Boolean = input.toIntOrNull() != null
    private fun isNumber(input: List<String>): Boolean = input.all { it.toIntOrNull() != null }
    private fun isValidateRange(input: Int): Boolean = input in 1..45
    private fun isValidateRange(input: List<Int>): Boolean = input.all { it in 1..45 }
    private fun isValidatePrice(price: Int): Boolean = price%1000 == 0
    private fun isDuplicated(numbers: List<Int>, bonusNumber: Int): Boolean = numbers.contains(bonusNumber)
    private fun canSplitByComma(input: String): Boolean = input.contains(",")
    private fun isValidateSize(input: List<Int>): Boolean = input.size == 6
    private fun isDuplicated(numbers: List<Int>): Boolean = numbers.distinct().size == numbers.size
    private fun splitByComma(input: String): List<String> = input.split(",").map { it.trim() }
    private fun isZero(input: Int): Boolean = input == 0
    private fun isMinus(input: Int): Boolean = input < 0

    fun lottoNumberValidator(lottoNumber: String) {
        if(!canSplitByComma(lottoNumber)) throw IllegalArgumentException(COMMA_REQUIRED.message)
        val list = splitByComma(lottoNumber)
        if(!isNumber(list)) throw IllegalArgumentException(NOT_NUMBER.message)
        val numberList = list.map { it.toInt() }
        if(!isValidateRange(numberList)) throw IllegalArgumentException(OUT_OF_RANGE.message)
        if(!isDuplicated(numberList)) throw IllegalArgumentException(DUPLICATED_NUMBER.message)
        if(!isValidateSize(numberList)) throw IllegalArgumentException(INVALID_SIZE.message)
    }

    fun moneyValidator(money: String) {
        if(!isNumber(money)) throw IllegalArgumentException(NOT_NUMBER.message)
        if(!isValidatePrice(money.toInt())) throw IllegalArgumentException(INVALID_PURCHASE_AMOUNT.message)
        if(isZero(money.toInt())) throw IllegalArgumentException(ZERO.message)
        if(isMinus(money.toInt())) throw IllegalArgumentException(MINUS.message)
    }

    fun bonusNumberValidator(numbers: List<Int>, bonusNumber: String, ) {
        if(!isNumber(bonusNumber)) throw IllegalArgumentException(NOT_NUMBER.message)
        if(!isValidateRange(bonusNumber.toInt())) throw IllegalArgumentException(OUT_OF_RANGE.message)
        if(isDuplicated(numbers, bonusNumber.toInt())) throw IllegalArgumentException(DUPLICATED_NUMBER.message)
    }
}