package lotto.domain

import lotto.domain.LottoShop.Companion.LOTTO_PRICE

class LottoBundle(private val lottos: List<Lotto>) {
    private val _winningRanksCount: HashMap<LottoRank, Int> = hashMapOf()
    val winningRanksCount: Map<LottoRank, Int> get() = _winningRanksCount.toMap()

    var totalPurchaseAmount: Int = lottos.size * LOTTO_PRICE
        private set

    var totalRevenue: Int = DEFAULT_VALUE
        private set

    init {
        LottoRank.values().forEach { rank ->
            _winningRanksCount.put(rank, DEFAULT_VALUE)
        }
    }

    fun getRateOfReturn(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Float {
        calculateTotalLottoRank(winningNumbers, bonusNumber)

        return (totalRevenue / totalPurchaseAmount).toFloat() * PERCENTAGE_MULTIPLIER
    }

    fun calculateTotalLottoRank(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        lottos.forEach { lotto ->
            lotto.calculateWinningRank(winningNumbers, bonusNumber)
            val lottoRank = lotto.lottoRank

            _winningRanksCount[lottoRank] = _winningRanksCount.getValue(lottoRank) + 1
            totalRevenue += lottoRank.prize
        }
    }

    fun forEach(action: (Lotto) -> Unit) = lottos.forEach { lotto -> action(lotto) }

    fun amount(): Int = lottos.size

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val PERCENTAGE_MULTIPLIER = 100
    }
}