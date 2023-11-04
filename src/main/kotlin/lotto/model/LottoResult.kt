package lotto.model

class LottoResult(
    private val winningNumbers: List<Int>,
    private val bonus: Int
) {
    fun calculateRanking(lottoTicket: List<Int>): Int {
        var winningCount = 0
        winningNumbers.forEach {
            if (lottoTicket.contains(it)) {
                winningCount++
            }
        }

        if (winningCount == 5) {
            if (lottoTicket.contains(bonus)) {
                winningCount = -1
            }
        }

        return winningCount
    }
}