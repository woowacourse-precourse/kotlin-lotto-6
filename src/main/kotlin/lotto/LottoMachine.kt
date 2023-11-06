package lotto

class LottoMachine {

    private var lottoTickets: List<Lotto> = listOf()

    fun generateLottoTickets() {
        createLottoTickets()
        println()
        displayLottoTickets()
    }

    private fun createLottoTickets() {
        println(PURCHASE_INSTRUCTION).also { lottoTickets = Player().purchaseLottoTickets() }
    }

    private fun displayLottoTickets() {
        println("${lottoTickets.size}${PURCHASE_TICKET_COUNT}").also { lottoTickets.forEach { println(it) } }
    }

    companion object {
        const val PURCHASE_INSTRUCTION = "구입금액을 입력해 주세요."
        const val PURCHASE_TICKET_COUNT = "개를 구매했습니다."
    }

}