package lotto.domain

class Validator {

    fun validatePrice(price: String) {
        validatePriceNotNum(price)
        validatePriceBlank(price)
        validatePrice1000Unit(price)
    }

    private fun validatePriceNotNum(price: String) {
        require(price.all { it.isDigit() })
    }

    private fun validatePriceBlank(price: String) {
        require(price.isNotBlank())
    }

    private fun validatePrice1000Unit(price: String) {
        require(price.toInt() % 1000 == 0)
    }

    fun validateLottoNum(lottoNum: List<String>) {
        validateLottoNumEmpty(lottoNum)
    }

    private fun validateLottoNumEmpty(lottoNum: List<String>) {
        require(lottoNum.isNotEmpty())
    }
}