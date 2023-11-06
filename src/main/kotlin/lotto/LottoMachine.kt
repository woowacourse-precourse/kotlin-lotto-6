package lotto

class LottoMachine {

    private var lottoTickets = LottoTickets()
    private var winningLotto = WinningLotto()

    fun generateLottoTickets() {
        lottoTickets.createLottoTickets().also { println() }
        lottoTickets.displayLottoTickets().also { println() }
    }

    fun generateWinningNumbers() {
        winningLotto.createWinningNumbers().also { println() }
        winningLotto.createBonusNumber().also { println() }
    }

    fun showStaticsResult() {
        val winningResult = lottoTickets.findWinningResult(winningLotto)
        println(winningResult)
    }

}