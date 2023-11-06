package lotto.utils

object InputViewValidation {

    fun isUserAmountValid(userInput: String): Boolean = try {

        true
    } catch (e: NumberFormatException) {
        false
    }
}