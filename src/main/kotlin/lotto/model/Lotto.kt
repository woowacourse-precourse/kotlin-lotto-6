package lotto.model

import lotto.model.validation.LottoNumValidation

class Lotto(numbers: List<Int>) {
    private var lotto: List<Int>
    private var bonusNum: Int? = null

    init {
        validateLottoNumbers(numbers)
        this.lotto = numbers
    }

    fun getLottoNumbers(): List<Int> = lotto

    fun setBonusNum(bonusNum: Int){
        validateBonusLottoNum(bonusNum)
        this.bonusNum = bonusNum
    }

    fun getBonusNumbers(): Int? {
        bonusNum?.let { return it }
        return null
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        LottoNumValidation().validateLottoNum(numbers)
    }

    private fun validateBonusLottoNum(bonusNum: Int){
        LottoNumValidation().validateBonusLottoNum(bonusNum)
    }
}
