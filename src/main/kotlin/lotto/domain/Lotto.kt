package lotto.domain

import lotto.exception.LottoException

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        checkLottoSize(numbers)
        checkNumberDuplicate(numbers)
    }

    private fun checkLottoSize(numbers: List<LottoNumber>) =
        require(numbers.size == 6) { LottoException.NUMBER_SIZE_NOT_MATCH.message }

    private fun checkNumberDuplicate(numbers: List<LottoNumber>) =
        require(numbers.toSet().size == numbers.size) { LottoException.DUPLICATE_NUMBER_EXIST.message }
}
