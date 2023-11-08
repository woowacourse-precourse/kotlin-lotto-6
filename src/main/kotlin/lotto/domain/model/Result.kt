package lotto.domain.model

enum class Result(val matchingNumberCount: Int, val prize: Int) {
    FIRST_PLACE(matchingNumberCount = 6, prize = 2_000_000_000),
    SECOND_PLACE(matchingNumberCount = 5, prize = 30_000_000),
    THIRD_PLACE(matchingNumberCount = 5, prize = 1_500_000),
    FOURTH_PLACE(matchingNumberCount = 4, prize = 50_000),
    FIFTH_PLACE(matchingNumberCount = 3, prize = 5_000),
    NOTHING(matchingNumberCount = 2, prize = 0)
}