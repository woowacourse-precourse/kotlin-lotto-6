package lotto

fun main() {
    with(LottoMachine()) {
        generateLottoTickets()
        generateWinningNumbers()
        showStaticsResult()
    }
}
