package lotto

fun main() {
    val game = Game()
    val amount = game.paying()
    val lottoTicketCount = game.calculating(amount)
    val lottoTickets = game.buying(lottoTicketCount)
}