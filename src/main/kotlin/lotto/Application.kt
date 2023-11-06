package lotto

fun main() {

}

fun buyLottoTickets(purchaseAmount: Int): List<Lotto> {
    val ticketCount = purchaseAmount / 1000
    return List(ticketCount) {
        val numbers = generateLottoNumbers()
        Lotto(numbers)
    }
}