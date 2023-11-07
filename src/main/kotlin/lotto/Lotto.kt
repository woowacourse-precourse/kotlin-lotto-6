package lotto

import lotto.util.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]", separator = ", ") { it.toString() }
    }

    companion object {

        fun fromInput(inputNumbers: String): Lotto {
            return Lotto(inputNumbers
                    .parseIntList()
                    .validateCount(LottoStore.LOTTO_NUMBER_COUNT)
                    .validateUnique(LottoStore.LOTTO_NUMBER_COUNT)
                    .validateRange(LottoStore.LOTTO_MIN_NUMBER, LottoStore.LOTTO_MAX_NUMBER))
        }

        fun fromList(numbers: List<Int>): Lotto {
            return Lotto(numbers)
        }
    }
}
