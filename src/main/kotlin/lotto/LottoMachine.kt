package lotto

class LottoMachine {

    private var lottoTickets = LottoTickets()
    private var winningLotto = WinningLotto()
    private lateinit var lottoResult: LottoResult

    fun init() {
        generateLottoTickets()
        generateWinningNumbers()
        generateResult()
    }

    private fun generateLottoTickets() {
        lottoTickets.initializeLottoTickets().also { println() }
        lottoTickets.displayLottoTickets().also { println() }
    }

    private fun generateWinningNumbers() {
        winningLotto.initializeWinningNumbers().also { println() }
        winningLotto.initializeBonusNumber().also { println() }
    }

    private fun generateResult() {
        lottoResult = LottoResult(lottoTickets, winningLotto)
        lottoResult.createResult()
        lottoResult.displayResult()
    }

}