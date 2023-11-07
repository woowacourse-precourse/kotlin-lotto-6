package lotto.domain

import lotto.util.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]", separator = ", ") { it.toString() }
    }

    fun toList(): List<Int> {
        return numbers
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun fromInput(inputNumbers: String): Lotto {
            return fromList(inputNumbers.parseIntList())
        }

        fun fromList(numbers: List<Int>): Lotto {
            return Lotto(numbers
                    .validateCount(LottoStore.LOTTO_NUMBER_COUNT)
                    .validateUnique(LottoStore.LOTTO_NUMBER_COUNT)
                    .validateRange(LottoStore.LOTTO_MIN_NUMBER, LottoStore.LOTTO_MAX_NUMBER))
        }
    }
}
