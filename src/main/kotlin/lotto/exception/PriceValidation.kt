package lotto.exception

class PriceValidation(private val price: String) {

    init {
        validatePriceDigit()
        validatePriceUnit()
        validatePricePositive()
    }

    private fun validatePriceDigit() {
        require(price.toIntOrNull() != null) {
            ErrorConstants.INVALID_PRICE_FORMAT_ERROR
        }
    }

    private fun validatePriceUnit() {
        require(price.toInt() % 1000 == 0) {
            ErrorConstants.INVALID_PRICE_UNIT_ERROR
        }
    }

    private fun validatePricePositive() {
        require(price.toInt() >= 1000) {
            ErrorConstants.INVALID_PRICE_RANGE_ERROR
        }
    }
}