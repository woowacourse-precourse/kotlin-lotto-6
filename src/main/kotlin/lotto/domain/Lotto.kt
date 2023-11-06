package lotto.domain

import lotto.exception.LottoException

class Lotto(private val numbers: List<LottoNumber>) {
    companion object {
        const val LOTTO_SIZE = 6
    }

    init {
        checkLottoSize(numbers)
        checkNumberDuplicate(numbers)
    }

    private fun checkLottoSize(numbers: List<LottoNumber>) =
        require(numbers.size == LOTTO_SIZE) { LottoException.NUMBER_SIZE_NOT_MATCH.message }

    private fun checkNumberDuplicate(numbers: List<LottoNumber>) =
        require(numbers.toSet().size == numbers.size) { LottoException.DUPLICATE_NUMBER_EXIST.message }

    override fun toString(): String {
        return numbers.toString()
    }
}
