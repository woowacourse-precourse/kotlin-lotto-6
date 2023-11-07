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


    fun validateBonusNum(bonusNum: String, lottoNum: List<Int>) {
        validateBonusNumIsBlank(bonusNum)
        validateBonusNumRange(bonusNum)
        validateBonusNumDuplicateLottoNum(bonusNum, lottoNum)
    }

    private fun validateBonusNumIsBlank(bonusNum: String) {
        require(bonusNum.isNotBlank())
    }

    private fun validateBonusNumRange(bonusNum: String) {
        require(bonusNum.toInt() in 1..45)
    }

    private fun validateBonusNumDuplicateLottoNum(bonusNum: String, lottoNum: List<Int>) {
        require(!lottoNum.contains(bonusNum.toInt()))
    }
}