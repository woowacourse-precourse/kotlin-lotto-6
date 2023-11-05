package lotto.constants

enum class Constants(val value: Int) {
    PURCHASE_AMOUNT_UNIT(1000),
    LOTTO_SIZE(6),
    LOTTO_START(1),
    LOTTO_END(45),
    LOTTO_MAX_COUNT(100);

    override fun toString() = value.toString()
}