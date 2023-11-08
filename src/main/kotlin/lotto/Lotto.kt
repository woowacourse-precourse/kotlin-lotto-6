package lotto

import lotto.ErrorConstants.DUPLICATE_NUMBER_ERROR
import lotto.ErrorConstants.INVALID_LOTTO_COUNT_ERROR
import lotto.ErrorConstants.INVALID_LOTTO_NUMBER_ERROR
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN
import lotto.LottoConstants.LOTTO_NUMBER_SIZE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_LOTTO_COUNT_ERROR }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { DUPLICATE_NUMBER_ERROR }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { INVALID_LOTTO_NUMBER_ERROR }
    }

    override fun toString(): String = "$numbers"

    fun contains(number: Int): Boolean = numbers.contains(number)


    fun match(other: Lotto): Int = numbers.intersect(other.numbers.toSet()).size


    fun matchBonus(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)
}
