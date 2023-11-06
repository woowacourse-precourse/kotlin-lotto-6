package lotto

class LottoResultChecker {

    private val winningResult: MutableMap<WinningCriteria, Int> = mutableMapOf(
        WinningCriteria.FIRST to 0,
        WinningCriteria.SECOND to 0,
        WinningCriteria.THIRD to 0,
        WinningCriteria.FOURTH to 0,
        WinningCriteria.FIFTH to 0
    )
    private var earnings = 0

    fun compareLottoTicketsWithWinningNumbers(
        lottoTickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<WinningCriteria, Int> {
        lottoTickets.forEach { lotto ->
            val result = setWinningResult(lotto.countSameNumber(winningNumbers), lotto.hasBonusNumber(bonusNumber))
            if (result != WinningCriteria.NONE) {
                winningResult[result] = winningResult.getOrDefault(result, 0) + 1
                addEarnings(result.prize)
            }
        }
        return winningResult.toMap()
    }

    fun setWinningResult(matchingNumber: Int, hasBonusNumber: Boolean): WinningCriteria {
        return when {
            matchingNumber == 6 -> WinningCriteria.FIRST
            matchingNumber == 5 && hasBonusNumber -> WinningCriteria.SECOND
            matchingNumber == 5 && !hasBonusNumber -> WinningCriteria.THIRD
            matchingNumber == 4 -> WinningCriteria.FOURTH
            matchingNumber == 3 -> WinningCriteria.FIFTH
            else -> WinningCriteria.NONE
        }
    }

    fun addEarnings(price: Int) {
        earnings += price
    }

    fun calculateEarningRate(inputPrice: Int): Double {
        return (earnings.toDouble() / inputPrice) * 100
    }
}