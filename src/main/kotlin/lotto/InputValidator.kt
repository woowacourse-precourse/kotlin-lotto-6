package lotto

object InputValidator {

    fun checkIsNotBlank(input: String) {
        require(input.isNotBlank()) { Constants.ERROR_BLANK_MESSAGE }
    }

    fun checkIsDigit(input: String) {
        require(!input.map { Character.isDigit(it) }.contains(false)) { Constants.ERROR_NUMBER_FORMAT_MESSAGE }
    }

    fun checkHasCommaSeparator(input: String) {
        require(input.contains(Constants.COMMA)) { Constants.ERROR_SEPARATOR_MESSAGE }
    }
}