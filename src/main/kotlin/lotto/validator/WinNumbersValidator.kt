package lotto.validator

class WinNumbersValidator : InputValidator() {
    init {
        checkForLength()
        checkForDigit()
        checkForNumberRange()
    }
}
