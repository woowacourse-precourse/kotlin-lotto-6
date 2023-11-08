package lotto

fun main() {
    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    val tickets = lotto.getLottoNumbers()
    val winningNumbers = lotto.getWinningNumbers()
    val bonusNumber = lotto.getBonusNumber(winningNumbers)
    lotto.showWinningNumbers(tickets, winningNumbers, bonusNumber)
}
