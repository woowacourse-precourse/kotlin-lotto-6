package lotto

enum class LottoPrice(private val price: Int) {
    THREE_MATCHED(5000),
    FOUR_MATCHED(50_000),
    FIVE_MATCHED(1_500_000),
    FIVE_BONUS_MATCHED(30_000_000),
    SIX_MATCHED(2_000_000_000);

    fun calculatePrice(count: Int) = price * count
}