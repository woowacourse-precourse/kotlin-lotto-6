package lotto


fun buyLottoTickets(price: Int): List<Lotto> {
    val lottoGameTicketCount = price / LottoConstraints.TICKET_PRICE
    val tickets: MutableList<Lotto> = mutableListOf()
    repeat(lottoGameTicketCount) {
        val ticket = makeLottoTicket()
        tickets.add(ticket)
    }
    displayPurchasement(lottoGameTicketCount, tickets)
    return tickets
}

