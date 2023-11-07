package lotto

class Referee(
    private val winningLotto: Lotto,
    private val bonusNumber: Int,
) {
    fun determineRank(lottos: List<Lotto>): List<LottoRank> {
        return lottos
            .map { lotto -> determineRank(lotto) }
            .filter { lotto -> lotto.prize > ZERO }
    }

    private fun determineRank(lotto: Lotto): LottoRank {
        val matchedCount = lotto.countMatch(winningLotto)
        val isContainsBonusNumber = lotto.contains(bonusNumber)
        return LottoRank.of(matchedCount, isContainsBonusNumber)
    }

    companion object {
        private const val ZERO = 0
    }
}