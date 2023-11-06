package lotto.model

import lotto.model.validation.LottoNumValidation

class Lotto(numbers: List<Int>) {
    private var lotto: List<Int>
    private var bonusNum: Int? = null

    constructor(numbers: List<Int>, bonusNum: Int) : this(numbers) {
        this.bonusNum = bonusNum
    }

    init {
        validateLottoNumbers(numbers)
        lotto = numbers
    }

    fun getLottoNumbers(): List<Int> {
        return lotto
    }

    fun getBonusNumbers(): Int? {
        bonusNum?.let { return it }
        return null
    }

    private fun validateLottoNumbers(numbers: List<Int>){
        LottoNumValidation().validateLottoNum(numbers)
    }
}
