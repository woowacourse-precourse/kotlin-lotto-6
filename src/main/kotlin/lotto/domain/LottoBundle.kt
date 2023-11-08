package lotto.domain

class LottoBundle(private val lottos: List<Lotto>) {
    private val _winningRanksCount: HashMap<LottoRank, Int> = hashMapOf()
    val winningRanksCount: Map<LottoRank, Int> get() = _winningRanksCount.toMap()

    init {
        LottoRank.values().forEach { rank ->
            _winningRanksCount.put(rank, 0)
        }
    }

    fun calculateTotalLottoRank(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        lottos.forEach { lotto ->
            lotto.calculateWinningRank(winningNumbers, bonusNumber)
            val lottoRank = lotto.lottoRank
            _winningRanksCount[lottoRank] = _winningRanksCount.getValue(lottoRank) + 1
        }
    }

    fun forEach(action: (Lotto) -> Unit) = lottos.forEach { lotto -> action(lotto) }

    fun amount(): Int = lottos.size
}