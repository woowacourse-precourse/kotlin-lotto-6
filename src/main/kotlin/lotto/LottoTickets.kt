package lotto

class LottoTickets {

    private var _tickets: List<Lotto> = listOf()
    val tickets: List<Lotto>
        get() = _tickets

    fun createLottoTickets() {
        println(PURCHASE_INSTRUCTION)
        initializeLottoTickets()
    }

    private fun initializeLottoTickets() {
        _tickets = Player().purchaseLottoTickets()
    }

    fun displayLottoTickets() {
        println("${tickets.size}${PURCHASE_TICKET_COUNT}")
        tickets.forEach { println(it) }
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

    companion object {
        const val PURCHASE_INSTRUCTION = "구입금액을 입력해 주세요."
        const val PURCHASE_TICKET_COUNT = "개를 구매했습니다."
    }

}