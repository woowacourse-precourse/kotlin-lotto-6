package lotto.model

import lotto.util.randomNumberGenerator

class Lotto(numbers: List<Int>) {
    private var lotto: List<Int>

    init {
        validateLottoNumbers(numbers)
        lotto = numbers
    }

    fun getLottoNumbers(): List<Int> {
        return lotto
    }

    private fun validateLottoNumbers(numbers: List<Int>){
        LottoNumValidation().validateLottoNum(numbers)
    }
}
