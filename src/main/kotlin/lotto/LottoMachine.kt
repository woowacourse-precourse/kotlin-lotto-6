package lotto

class LottoMachine {

    private var lottoTickets = LottoTickets()
    private var winningLotto = WinningLotto()

    fun init() {
        generateLottoTickets()
        generateWinningNumbers()
        showStaticsResult()
    }

    private fun generateLottoTickets() {
        lottoTickets.createLottoTickets().also { println() }
        lottoTickets.displayLottoTickets().also { println() }
    }

    private fun generateWinningNumbers() {
        winningLotto.createWinningNumbers().also { println() }
        winningLotto.createBonusNumber().also { println() }
    }

    private fun showStaticsResult() {
        val lottoResult = LottoResult(lottoTickets, winningLotto)
        lottoResult.findWinningResult()
    }

}