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

    companion object {
        const val PURCHASE_INSTRUCTION = "구입금액을 입력해 주세요."
        const val PURCHASE_TICKET_COUNT = "개를 구매했습니다."
    }

}