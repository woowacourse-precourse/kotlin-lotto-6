package lotto.util

import lotto.util.Constants.DELIMITER
import lotto.util.Constants.LOTTO_PURCHASE_COST
import lotto.util.Constants.LOTTO_RANGE_END
import lotto.util.Constants.LOTTO_RANGE_START
import lotto.util.Constants.LOTTO_SIZE
import lotto.util.Constants.ZERO_NUM


private const val POSITIVE_NUM = 1

object Validator {
    private fun isItInteger(input: String) {
        val value = input.toIntOrNull()
        require(value != null) { ErrorMessage.NOT_NOT_INTEGER.msg}
    }

    private fun isItPositive(input: Int) {
        require(input >= POSITIVE_NUM) { ErrorMessage.NOT_POSITIVE_INTEGER .msg}
    }

    private fun isItNotEmpty(input: String) {
        require(input.trim().isNotEmpty()) { ErrorMessage.EMPTY_INPUT.msg}
    }

    private fun isDivisibleByThousand(input: Int) {
        require(input % LOTTO_PURCHASE_COST == ZERO_NUM) {  ErrorMessage.NOT_DIVISIBLE.msg }
    }

    private fun isNumInRange(input: Int) {
        require(input in LOTTO_RANGE_START..LOTTO_RANGE_END) { ErrorMessage.NOT_IN_RANGE.msg}
    }

    private fun isNumsDuplicated(input: List<String>) {
        require(input.size == input.toSet().size) { ErrorMessage.DUPLICATE_VALUES.msg}
    }

    private fun isProperSize(input:List<String>) {
        require(input.size == LOTTO_SIZE){ErrorMessage.INVALID_SIZE.msg}
    }
    private fun isNumExist(input: Int,winningNums: List<Int>){
        require(!winningNums.contains(input)){ErrorMessage.ALREADY_EXISTS.msg}
    }

    fun isValidPurchaseAmount(input: String) {
        isItNotEmpty(input)
        isItInteger(input)
        isItPositive(input.toInt())
        isDivisibleByThousand(input.toInt())
    }

    fun isValidWinningNums(input: String) {
        val userInput = input.split(DELIMITER)
        userInput.forEach {
            isItNotEmpty(it)
            isItInteger(it)
            isItPositive(it.toInt())
            isNumInRange(it.toInt())
        }
        isNumsDuplicated(userInput)
        isProperSize(userInput)
    }

    fun isValidBonusNum(input: String,winningNums:List<Int>){
        isItNotEmpty(input)
        isItInteger(input)
        isNumInRange(input.toInt())
        isNumExist(input.toInt(),winningNums)
    }
}