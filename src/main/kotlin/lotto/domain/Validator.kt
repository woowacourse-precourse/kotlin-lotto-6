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
        validateLottoNumCount(lottoNum)
        validateLottoNumRange(lottoNum)
        validateLottoNumDuplicate(lottoNum)
    }

    private fun validateLottoNumEmpty(lottoNum: List<String>) {
        require(lottoNum.isNotEmpty())
    }

    private fun validateLottoNumCount(lottoNum: List<String>) {
        require(lottoNum.size == 6)
    }

    private fun validateLottoNumRange(lottoNum: List<String>) {
        for (element in lottoNum) {
            require(element.toInt() in 1..45)
        }
    }

    private fun validateLottoNumDuplicate(lottoNum: List<String>) {
        require(lottoNum.size != lottoNum.distinct().count())
    }
}