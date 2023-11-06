package lotto.domain

class Validator() {

    fun validatePrice(price: String) {
        validatePriceNotNum(price)
        validatePriceBlank(price)
    }

    private fun validatePriceNotNum(price: String) {
        require(price.all { it.isDigit() })
    }

    fun validatePriceBlank(price: String) {
        require(price.isNotBlank())
    }
}