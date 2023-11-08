package lotto.domain

enum class LottoRule(val num: Int) {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6),
    PRICE(1_000)
}