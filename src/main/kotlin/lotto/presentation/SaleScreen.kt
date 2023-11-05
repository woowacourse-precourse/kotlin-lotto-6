package lotto.presentation

class SaleScreen {
    fun outputTicketCount(count: Int) {
        println("\n${count}개를 구매했습니다.")
    }

    fun outputTickets(lottoTickets: List<List<Int>>) {
        lottoTickets.forEach {
            println(it)
        }
    }
}