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

    fun validateLottoNum(lottoNum: List<Int>) {
        validateLottoNumEmpty(lottoNum)
        validateLottoNumCount(lottoNum)
        validateLottoNumRange(lottoNum)
        validateLottoNumDuplicate(lottoNum)
    }

    private fun validateLottoNumEmpty(lottoNum: List<Int>) {
        require(lottoNum.isNotEmpty()) {"비어있음"}
    }

    private fun validateLottoNumCount(lottoNum: List<Int>) {
        require(lottoNum.size == 6) {"6자리 아님"}
    }

    private fun validateLottoNumRange(lottoNum: List<Int>) {
        for (element in lottoNum) {
            require(element.toInt() in 1..45) {"범위 밖임"}
        }
    }

    private fun validateLottoNumDuplicate(lottoNum: List<Int>) {
        require(lottoNum.size == lottoNum.distinct().count()) {"중복됨"}
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