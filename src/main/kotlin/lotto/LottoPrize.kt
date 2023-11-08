package lotto

enum class LottoPrize(val prizeAmount: Float) {
    THREE_MATCH(5000f),
    FOUR_MATCH(50000f),
    FIVE_MATCH(1500000f),
    FIVE_BONUS_MATCH(30000000f),
    SIX_MATCH(2000000000f)
}