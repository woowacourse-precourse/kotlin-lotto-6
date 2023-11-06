package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.isInLottoNumberRange
import lotto.util.isUnique
import lotto.util.lottoNumberRange

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE)
        require(numbers.isUnique())
        require(numbers.isInLottoNumberRange())
    }

    operator fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    override fun toString(): String {
        return "[${numbers.joinToString()}]"
    }

    companion object {
        private const val SIZE = 6

        fun random(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(
                lottoNumberRange.first,
                lottoNumberRange.last,
                SIZE
            )
            val sorted = numbers.sorted()
            return Lotto(sorted)
        }
    }
}
