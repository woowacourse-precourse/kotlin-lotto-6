package lotto.model

import lotto.domain.RandomGenerator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoState(): List<LottoState> {
        return numbers.map { LottoState(it) }
    }

    companion object {
        fun makeLotto(randomLottoGenerator: RandomGenerator): Lotto {
            return Lotto(randomLottoGenerator.pickNumberInRange(0, 45, 6))
        }
    }
}
