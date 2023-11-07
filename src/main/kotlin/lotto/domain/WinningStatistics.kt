package lotto.domain

enum class Match(val value: Int) {
    THREE(0), FOUR(1), FIVE(2), FIVE_AND_BONUS(3), SIX(4)
}

class WinningStatistics {
    fun getWinningDetails(lottos: MutableList<Lotto>, winningNumber: List<Int>, bonusNumber: Int): MutableList<Int> {
        val winningDetails = MutableList(5) { 0 }

        for (lotto in lottos) {
            val matchNumber = winningNumber.count { lotto.getLotto().contains(it) }
            val isBonusNumberMatching = lotto.getLotto().contains(bonusNumber)

            when (matchNumber) {
                3 -> winningDetails[Match.THREE.value]++
                4 -> winningDetails[Match.FOUR.value]++
                5 -> if (isBonusNumberMatching) winningDetails[Match.FIVE_AND_BONUS.value]++ else winningDetails[Match.FIVE.value]++
                6 -> winningDetails[Match.SIX.value]++
                else -> null
            }
        }
        return winningDetails
    }
}