package lotto.data

enum class Rank(
    val grade: Int,
    val prize: Int
) {
    ALL_MATCH(1, 2_000_000_000),
    FIVE_MATCH_WITH_BONUS(2, 30_000_000),
    FIVE_MATCH(3, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(5, 5_000),
    NOT_MATCH(0, 0)
}