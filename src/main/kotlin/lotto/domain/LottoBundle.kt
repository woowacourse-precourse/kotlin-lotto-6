package lotto.domain

import lotto.domain.LottoShop.Companion.LOTTO_PRICE

class LottoBundle(private val lottos: List<Lotto>) {

    private val _winningRanksCount: HashMap<LottoRank, Int> = hashMapOf()
    val winningRanksCount: Map<LottoRank, Int> get() = _winningRanksCount.toMap()

    var totalPurchaseAmount: Int = lottos.size * LOTTO_PRICE
        private set

    var totalRevenue: Int = REVENUE_INIT_VALUE
        private set

    init {
        LottoRank.values().forEach { rank ->
            _winningRanksCount.put(rank, DEFAULT_VALUE)
        }
    }

    fun forEach(action: (Lotto) -> Unit) = lottos.forEach { lotto -> action(lotto) }

    fun amount(): Int = lottos.size

    fun calculateTotalLottoRank(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        totalRevenue = DEFAULT_VALUE

        lottos.forEach { lotto ->
            lotto.calculateWinningRank(winningNumbers, bonusNumber)
            val lottoRank = lotto.lottoRank

            _winningRanksCount[lottoRank] = _winningRanksCount.getValue(lottoRank) + 1
            totalRevenue += lottoRank.prize.money
        }
    }

    fun getRateOfReturn(): Float {
        check(totalRevenue != REVENUE_INIT_VALUE){
            "[ERROR] 수익률 계산은 먼저 해당 로또들의 등수를 확인한 후 진행 해주세요."
        }
        return (totalRevenue.toFloat() / totalPurchaseAmount.toFloat()) * PERCENTAGE_MULTIPLIER
    }

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val REVENUE_INIT_VALUE = -1
        private const val PERCENTAGE_MULTIPLIER = 100
    }
}