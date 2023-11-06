package lotto

class LottoTickets {

    private var _tickets: List<Lotto> = listOf()
    val tickets: List<Lotto>
        get() = _tickets

    fun initializeLottoTickets() {
        _tickets = Player().purchaseLottoTickets()
    }

    fun findWinningResult(winningLotto: WinningLotto): List<Prize> {
        val matchedNumbersCounts = calculateMatchedNumberCounts(winningLotto)
        val bonusNumberExists = checkForBonusNumber(winningLotto)
        return List(tickets.size) { index ->
            Prize.findPrizeResult(matchedNumbersCounts[index], bonusNumberExists[index])
        }
    }

    private fun calculateMatchedNumberCounts(winningLotto: WinningLotto): List<Int> {
        return tickets.map { it.countMatchingNumbers(winningLotto.winningNumbers) }
    }

    private fun checkForBonusNumber(winningLotto: WinningLotto): List<Boolean> {
        return tickets.map { it.hasBonusNumber(winningLotto.bonusNumber) }
    }

}