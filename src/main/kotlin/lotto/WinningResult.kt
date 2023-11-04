package lotto

enum class WinningResult {
    None,
    Three,
    Four,
    Five,
    FiveAndBonus,
    Six;

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
