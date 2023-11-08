package util

enum class LottoConfiguration(val value: Int) {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    NUMBER_COUNT(6),
    TICKET_PRICE(1_000),
    MAX_PURCHASE_PRICE(100_000),
    MIN_PURCHASE_PRICE(1_000),
    MIN_OUTPUT_RANK(5),
    MAX_OUTPUT_RANK(1),
}
