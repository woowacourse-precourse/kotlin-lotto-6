package lotto.model

class Lotto(private val numbers: List<Int>) {
    lateinit var lottoNumbers: List<Int>

    init {
        LottoNumValidation().validateLottoNum(numbers)
        lottoNumbers = numbers
    }
}
