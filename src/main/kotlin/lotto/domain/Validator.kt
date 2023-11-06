package lotto.domain

class Validator() {
    fun validatePriceNotNum(price: String) {
        require(price.all { it.isDigit() })
    }
}