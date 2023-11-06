package lotto

class LottoMachine {

    private var lottoTickets: List<Lotto> = listOf()
    private var winningLotto = WinningLotto()

    fun generateLottoTickets() {
        createLottoTickets().also { println() }
        displayLottoTickets().also { println() }
    }

    private fun createLottoTickets() {
        println(PURCHASE_INSTRUCTION)
        lottoTickets = Player().purchaseLottoTickets()
    }

    private fun displayLottoTickets() {
        println("${lottoTickets.size}${PURCHASE_TICKET_COUNT}")
        lottoTickets.forEach { println(it) }
    }

    fun generateWinningNumbers() {
        createWinningNumbers().also { println() }
        createBonusNumber().also { println() }
    }

    private fun createWinningNumbers() {
        println(INPUT_WINNING_NUMBERS)
        winningLotto.initializeWinningNumbers()
    }

    private fun createBonusNumber() {
        println(INPUT_BONUS_NUMBER)
        winningLotto.initializeBonusNumber()
    }


    companion object {
        const val PURCHASE_INSTRUCTION = "구입금액을 입력해 주세요."
        const val PURCHASE_TICKET_COUNT = "개를 구매했습니다."
        const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }

}