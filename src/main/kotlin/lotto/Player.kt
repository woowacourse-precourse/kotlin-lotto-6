package lotto

import camp.nextstep.edu.missionutils.Console

class Player {

    fun purchaseLottoTickets(): List<Lotto> {
        val payment = readTicketPayment()
        val ticketCount = calculateTicketCount(payment)
        return createTickets(ticketCount)
    }

    private fun readTicketPayment(): Int {
        var input: String
        do {
            println(InfoMessage.PURCHASE_INSTRUCTION.message)
            input = Console.readLine().trim()
        } while (!Validator(input).isPaymentValid())
        return input.toInt()
    }

    private fun calculateTicketCount(payment: Int): Int = payment / 1_000

    private fun createTickets(ticketCount: Int): List<Lotto> {
        val lottoTicketGenerator = LottoTicketGenerator()
        return List(ticketCount) { lottoTicketGenerator.createAutoTicket() }
    }
}