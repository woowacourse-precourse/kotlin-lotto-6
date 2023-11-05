package lotto.validator

class PurchasePriceValidator(value: String) : InputValidator() {
    init {
        checkBlank(value)
        checkForPositiveInteger(value)
        checkForValidAmount(value)
    }
}
