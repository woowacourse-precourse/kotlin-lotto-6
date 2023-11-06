package lotto

fun main() {
    val game = Game()
    val amount = game.paying()
    val lottoTicketCount = game.calculating(amount)
    val lottoTickets = game.buying(lottoTicketCount)
    val drawNumber = game.drawing()
    println(drawNumber)
    val bonusNumber = game.bonusDrawing(drawNumber)
    println(bonusNumber)
}