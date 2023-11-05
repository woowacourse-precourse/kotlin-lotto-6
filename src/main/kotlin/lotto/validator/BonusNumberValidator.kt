package lotto.validator

class BonusNumberValidator : InputValidator() {
    init {
        checkForLength()
        checkForDigit()
        checkForPositiveInteger()
        checkForNumberRange()
    }
}
