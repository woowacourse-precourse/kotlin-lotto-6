package lotto.presentation

class SaleScreen {
    fun outputTicketCount(count: Int) = println(LINE_SEPARATOR + "$count$TICKET_COUNT")

    fun outputTickets(lottoTickets: List<List<Int>>) =
        lottoTickets.forEach {
            println(it)
        }

    companion object {
        const val TICKET_COUNT = "개를 구매했습니다."
        const val LINE_SEPARATOR = "\n"
    }
}