package lotto.domain

class ResultCalculator(
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto
) {
    fun calculateResult(): LottoResult {
        val result = LottoResult()

        for (lotto in lottos) {
            val count = winningLotto.calculateMatchingCount(lotto)
            val bonus = winningLotto.calculateBonusMatch(lotto)
            val rank = Rank.checkRank(count, bonus)
            result.addCount(rank)
        }
        return result
    }
}