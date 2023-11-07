package lotto

enum class Rank(
    val winningNumber: Int,
    val money: Double,
) {
    FIRST_RANK(6, 2_000_000_000.0),
    SECOND_RANK(5, 30_000_000.0),
    THIRD_RANK(5, 1_500_000.0),
    FOURTH_RANK(4, 50_000.0),
    FIFTH_RANK(3, 5_000.0),
    MISS(0, 0.0),
}