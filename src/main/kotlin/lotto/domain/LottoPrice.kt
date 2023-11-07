package lotto.domain

enum class LottoPrice(val matchCount: Int, val price: Int) {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    BONUS_MATCH(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000)
}