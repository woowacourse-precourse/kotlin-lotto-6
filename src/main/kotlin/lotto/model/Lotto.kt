package lotto.model

import lotto.domain.RandomGenerator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoState(): List<Int> {
        return numbers
    }

    companion object {
        fun makeLotto(randomLottoGenerator: RandomGenerator): Lotto {
            return Lotto(randomLottoGenerator.pickNumberInRange(1, 45, 6))
        }
    }
}
