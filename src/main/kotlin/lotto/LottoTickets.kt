package lotto

class LottoTickets {

    private var _tickets: List<Lotto> = listOf()
    val tickets: List<Lotto> get() = _tickets

    fun initializeLottoTickets() {
        _tickets = Player().purchaseLottoTickets()
    }

}