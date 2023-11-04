package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE)
        require(numbers.isUnique())
        require(numbers.isInLottoNumberRange())
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private const val SIZE = 6

        fun random(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(
                lottoNumberRange.first,
                lottoNumberRange.last,
                SIZE
            )
            return Lotto(numbers)
        }
    }
}
