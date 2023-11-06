package lotto

import camp.nextstep.edu.missionutils.Console

class Player {

    fun purchaseLottoTickets(): List<Lotto> {
        val payment = readTicketPayments()
        val ticketCounts = calculateTicketCounts(payment)
        return createTickets(ticketCounts)
    }

    // TODO 지불한 돈 예외처리
    private fun readTicketPayments(): Int {
        return Console.readLine().trim().toInt()
    }

    private fun calculateTicketCounts(payment: Int): Int {
        return payment / 1_000
    }

    private fun createTickets(ticketCount: Int): List<Lotto> {
        val lottoTicketGenerator = LottoTicketGenerator()
        return List(ticketCount) { lottoTicketGenerator.createAutoTicket() }
    }
}