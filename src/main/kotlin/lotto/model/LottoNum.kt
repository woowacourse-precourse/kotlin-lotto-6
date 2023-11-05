package lotto.model

class LottoNum(private val numbers: List<Int>) {
    private var lottoNumbers: List<Int>

    init {
        LottoNumValidation().validateLottoNum(numbers)
        lottoNumbers = numbers
    }

    fun getLottoNumbers(): List<Int> {
        return lottoNumbers
    }
}
