package lotto.exception

class PriceValidation(private val price: String) {

    init {
        validatePriceUnit()
        validatePricePositive()
        validatePriceNumber()
    }

    private fun validatePriceUnit() {
        require(price.toInt() % 1000 == 0) {
            "[ERROR] 1,000원 단위의 값을 입력해주세요."
        }
    }

    private fun validatePricePositive() {
        require(price.toInt() >= 1000) {
            "[ERROR] 1,000원 이상의 값을 입력해주세요."
        }
    }

    private fun validatePriceNumber() {
        require(price.matches(Regex("[0-9]"))) {
            "[ERROR] 숫자만 입력해주세요."
        }
    }
}