package lotto


fun buyLottoTickets(price: Int): List<Lotto> {
    val lottoGameTicketCount = price / LottoConstraints.TICKET_PRICE
    displayPurchasement(lottoGameTicketCount)
    val tickets: MutableList<Lotto> = mutableListOf()
    repeat(lottoGameTicketCount) {
        val ticket = makeLottoTicket()
        displayTicketInfo(ticket)
        tickets.add(ticket)
    }
    return tickets
}