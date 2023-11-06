package lotto.domain

class ResultCalculator(
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto
) {
    private var matchingCount = 0
    private var bonusMatch = false

    fun calculateResult(): LottoResult {
        val result = LottoResult()

        for (lotto in lottos) {
            calculateCount(lotto)
            isBonusMatch(lotto)
            result.addCount(Rank.checkRank(matchingCount, bonusMatch))
        }
        return result
    }

    private fun calculateCount(lotto: Lotto) {
        matchingCount = winningLotto.checkCountMatched(lotto)
    }

    private fun isBonusMatch(lotto: Lotto) {
        bonusMatch = winningLotto.checkBonusMatch(lotto)
    }
}