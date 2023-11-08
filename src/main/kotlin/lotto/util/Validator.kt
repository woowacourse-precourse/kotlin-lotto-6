package lotto.util

import lotto.constants.ErrorMessage

class Validator {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun checkPurchase(input: String?) {
        checkNullOREmpty(input)
        checkTypeInt(input)
    }

    private fun checkNullOREmpty(input: String?) {
        if(input.isNullOrEmpty()) throw IllegalArgumentException(errorMessage.INPUT_NULL_OR_EMPTY)
    }

    private fun checkTypeInt(input: String?) {
        require(input!!.chars().allMatch{ Character.isDigit(it) }) {throw IllegalArgumentException(errorMessage.INPUT_TYPE_NOT_INT)}
    }
}