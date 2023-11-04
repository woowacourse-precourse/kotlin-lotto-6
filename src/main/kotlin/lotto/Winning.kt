package lotto

enum class Winning(val moneyWon: Long, val matchCount: Int) {
    None(moneyWon = 0, matchCount = 0),
    Three(moneyWon = 5_000, matchCount = 3),
    Four(moneyWon = 50_000, matchCount = 4),
    Five(moneyWon = 1_500_000, matchCount = 5),
    FiveAndBonus(moneyWon = 30_000_000, matchCount = 5),
    Six(moneyWon = 2_000_000_000, matchCount = 6);

    companion object {
        fun create(winningCount: Int, bonusCount: Int): Winning {
            return when (winningCount + bonusCount) {
                in 0..2 -> None
                3 -> Three
                4 -> Four
                5 -> if (bonusCount == 1) FiveAndBonus else Five
                6 -> Six
                else -> throw IllegalArgumentException()
            }
        }
    }
}
