package lotto.model

import lotto.domain.RandomGenerator

class Lottos(purchaseCount: Int, randomGenerator: RandomGenerator) {
    private val lottos: List<Lotto>

    init {
        lottos = (1..purchaseCount).map {
            Lotto.makeLotto(randomGenerator)
        }
    }

    fun getLottosState(): List<LottosState> {
        return lottos.map { LottosState(it) }
    }

    fun getLottoPrizes(winningLotto: Lotto, bonusNumber: Int): List<LottoPrize> {
        return lottos.map {
            val winningCount = it.getWinningCount(winningLotto)
            LottoPrize.getLottoPrize(
                winningCount,
                it.confirmBonusNumber(winningCount, bonusNumber)
            )
        }
    }
}