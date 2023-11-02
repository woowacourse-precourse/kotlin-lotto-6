package lotto.util

class UserInputValidator {

    fun isNumberFormat(userInput: String) {
        require(userInput.none { char -> !char.isDigit() })
    }

    fun isNumberListFormat(userInput: List<String>) {
        userInput.forEach { require(it.none { char -> !char.isDigit() }) }
    }
}