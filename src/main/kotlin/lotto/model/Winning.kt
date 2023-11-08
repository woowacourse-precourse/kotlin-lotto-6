package lotto.model

enum class Winning(val priceWon: Long, val matchCount: Int) {
    None(priceWon = 0, matchCount = 0),
    Three(priceWon = 5_000, matchCount = 3),
    Four(priceWon = 50_000, matchCount = 4),
    Five(priceWon = 1_500_000, matchCount = 5),
    FiveAndBonus(priceWon = 30_000_000, matchCount = 5),
    Six(priceWon = 2_000_000_000, matchCount = 6);

    companion object {
        fun create(matchCount: Int, correctBonus: Boolean): Winning {
            return when (matchCount) {
                in 0..2 -> None
                3 -> Three
                4 -> Four
                5 -> if (correctBonus) FiveAndBonus else Five
                6 -> Six
                else -> throw IllegalArgumentException()
            }
        }
    }
}
