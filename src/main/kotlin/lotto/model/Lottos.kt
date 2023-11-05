package lotto.model

import lotto.domain.RandomGenerator

class Lottos(purchaseCount: Int, randomGenerator: RandomGenerator) {
    private val lottos: List<Lotto>

    init {
        lottos = (1..purchaseCount).map {
            Lotto.makeLotto(randomGenerator)
        }
    }

    fun getLottoState(): List<Lotto> {
        return lottos.map { LottosState(it).lotto }
    }
}