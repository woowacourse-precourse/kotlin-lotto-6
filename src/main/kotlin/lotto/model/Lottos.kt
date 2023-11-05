package lotto.model

import lotto.domain.RandomGenerator

class Lottos(purchaseCount: Int, randomGenerator: RandomGenerator) {
    private val lottos: List<Lotto>

    init {
        lottos = (1..purchaseCount).map {
            Lotto.makeLotto(randomGenerator)
        }
    }

    fun getLottoState(): List<LottosState> {
        return lottos.map { LottosState(it.getLottoState()) }
    }

    fun getLottoPrizes(winningLotto: Lotto, bonusNumber: Int): List<LottoPrize?> {
        return lottos.map {
            val winningCount = it.getWinningCount(winningLotto)
            LottoPrize.getLottoPrize(
                winningCount,
                it.confirmBonusNumber(winningCount, bonusNumber)
            )
        }
    }

    fun getLottoResult(lottoPrizes: List<LottoPrize?>): List<LottoResult> {
        val lottoResults = LottoPrize.entries.map { LottoResult(it) }
        lottoPrizes.forEach { lottoPrize ->
            lottoResults.firstOrNull {
                it.prize == lottoPrize
            }?.increasePrizeCount()
        }
        return lottoResults
    }
}