package lotto

class LottoMachine {

    private var lottoTickets = LottoTickets()
    private var winningLotto = WinningLotto()

    fun init() {
        generateLottoTickets()
        generateWinningNumbers()
        showResult()
    }

    private fun generateLottoTickets() {
        lottoTickets.createLottoTickets().also { println() }
        lottoTickets.displayLottoTickets().also { println() }
    }

    private fun generateWinningNumbers() {
        winningLotto.createWinningNumbers().also { println() }
        winningLotto.createBonusNumber().also { println() }
    }

    private fun showResult() {
        LottoResult(lottoTickets, winningLotto).printResult()
    }

}