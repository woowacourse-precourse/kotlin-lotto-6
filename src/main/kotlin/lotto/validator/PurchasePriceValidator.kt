package lotto.validator

class PurchasePriceValidator : InputValidator() {
    init {
        checkForDigit()
        checkForValidAmount()
    }
}
