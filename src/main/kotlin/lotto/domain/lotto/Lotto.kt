package lotto.domain.lotto

import lotto.exception.LottoException

class Lotto(private val numbers: List<LottoNumber>) {
    init {
        checkLottoSize(numbers)
        checkNumberDuplicate(numbers)
    }

    private fun checkLottoSize(numbers: List<LottoNumber>) =
        require(numbers.size == LOTTO_SIZE) { LottoException.NUMBER_SIZE_NOT_MATCH.getLottoSize(LOTTO_SIZE) }

    private fun checkNumberDuplicate(numbers: List<LottoNumber>) =
        require(numbers.toSet().size == numbers.size) { LottoException.DUPLICATE_NUMBER_EXIST.message }

    fun isContainLottoNumber(input: LottoNumber) = numbers.contains(input)

    fun getLottoMatchCount(input: Lotto) = numbers.count { input.isContainLottoNumber(it) }

    override fun toString(): String = numbers.sortedBy { it.value }.toString()

    companion object {
        const val LOTTO_SIZE = 6
    }
}
