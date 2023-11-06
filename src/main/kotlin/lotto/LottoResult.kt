package lotto

class LottoResult(private val lottoTickets: LottoTickets, private val winningLotto: WinningLotto) {
    fun findWinningResult(): List<Prize> {
        val matchedNumbersCounts = calculateMatchedNumberCounts(winningLotto)
        val bonusNumberExists = checkForBonusNumber(winningLotto)
        return List(lottoTickets.tickets.size) { index ->
            Prize.findPrizeResult(matchedNumbersCounts[index], bonusNumberExists[index])
        }
    }

    private fun calculateMatchedNumberCounts(winningLotto: WinningLotto): List<Int> {
        return lottoTickets.tickets.map { it.countMatchingNumbers(winningLotto.winningNumbers) }
    }

    private fun checkForBonusNumber(winningLotto: WinningLotto): List<Boolean> {
        return lottoTickets.tickets.map { it.hasBonusNumber(winningLotto.bonusNumber) }
    }
}