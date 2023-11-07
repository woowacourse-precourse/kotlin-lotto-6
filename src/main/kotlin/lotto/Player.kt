package lotto

import camp.nextstep.edu.missionutils.Console

class Player {

    fun purchaseLottoTickets(): List<Lotto> {
        val payment = readTicketPayment()
        val ticketCount = calculateTicketCount(payment)
        return createTickets(ticketCount)
    }

    // TODO 지불한 돈 예외처리
    private fun readTicketPayment(): Int = Console.readLine().trim().toInt()

    private fun calculateTicketCount(payment: Int): Int = payment / 1_000

    private fun createTickets(ticketCount: Int): List<Lotto> {
        val lottoTicketGenerator = LottoTicketGenerator()
        return List(ticketCount) { lottoTicketGenerator.createAutoTicket() }
    }
}