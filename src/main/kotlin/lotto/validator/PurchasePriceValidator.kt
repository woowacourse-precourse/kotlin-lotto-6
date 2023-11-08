package lotto.validator

class PurchasePriceValidator(price: String) : InputValidator() {
    init {
        checkBlank(price)
        checkForPositiveInteger(price)
        checkForValidAmount(price)
    }

    private fun checkForValidAmount(price: String) {
        require(price.toInt() >= 1000) { "[ERROR] 최소 1,000원 이상을 입력해 주세요" }
        require((price.toInt() % 1000) == 0) { "[ERROR] 1,000원 단위로 입력해 주세요" }
    }
}
