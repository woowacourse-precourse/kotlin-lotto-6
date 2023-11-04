package lotto

enum class WinningResult(val moneyWon: Long) {
    None(moneyWon = 0),
    Three(moneyWon = 5_000),
    Four(moneyWon = 50_000),
    Five(moneyWon = 1_500_000),
    FiveAndBonus(moneyWon = 30_000_000),
    Six(moneyWon = 2_000_000_000);

    companion object {
        fun create(winningCount: Int, bonusCount: Int): WinningResult {
            return when (winningCount + bonusCount) {
                3 -> Three
                4 -> Four
                5 -> if (bonusCount == 1) FiveAndBonus else Five
                6 -> Six
                else -> None
            }
        }
    }
}
