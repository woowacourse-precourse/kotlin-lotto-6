package lotto.domain.validator

object InputValidator {
    fun validateInputIsInt(input: String, message : String) = requireNotNull(input.toIntOrNull()) {
        "[ERROR] $message"
    }

    fun validateInputIsNotZero(input: String, message : String) = require(input.toInt() != 0) {
        "[ERROR] $message"
    }
}