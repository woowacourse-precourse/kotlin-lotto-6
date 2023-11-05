package lotto.presentation

class SaleScreen {
    fun outputTicketCount(count: Int) {
        println("$count$TICKET_COUNT")
    }

    fun outputTickets(lottoTickets: List<List<Int>>) {
        lottoTickets.forEach {
            println(it)
        }
    }

    companion object {
        const val TICKET_COUNT = "개를 구매했습니다."
    }
}