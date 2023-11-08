package lotto.model

import lotto.model.validation.LottoNumValidation

class Lotto(private val numbers: List<Int>) {
    private var lotto: List<Int>

    init {
        validateLottoNumbers(numbers)
        this.lotto = numbers
    }

    fun getLottoNumbers(): List<Int> = lotto
    private fun validateLottoNumbers(numbers: List<Int>) {
        LottoNumValidation().validateLottoNum(numbers)
    }
}
