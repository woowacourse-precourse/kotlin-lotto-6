package lotto.validator

class BonusNumberValidator(value: String) : InputValidator() {
    init {
        checkBlank(value)
        checkForPositiveInteger(value)
        checkForNumberRange(value)
    }
}
