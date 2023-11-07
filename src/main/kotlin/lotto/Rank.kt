package lotto

enum class Rank(
    private val winningNumber: Int,
    private val money: Int,
) {
    FIRST_RANK(6, 2_000_000_000),
    SECOND_RANK(5, 30_000_000),
    THIRD_RANK(5, 1_500_000),
    FOURTH_RANK(4, 50_000),
    FIFTH_RANK(3, 5_000),
    MISS(6, 0),
}