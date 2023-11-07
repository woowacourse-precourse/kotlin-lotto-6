package lotto.validator

class WinNumbersValidator(winNumbers: List<String>) : InputValidator() {
    init {
        winNumbers.forEach {
            checkBlank(it)
            checkForPositiveInteger(it)
            checkForNumberRange(it)
        }
        checkForWinNumbersLength(winNumbers)
        checkDuplicateForWinNumbers(winNumbers)

    }
}
