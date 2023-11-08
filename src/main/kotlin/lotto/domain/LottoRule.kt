package lotto.domain

enum class LottoRule(val num: Int) {
    NULL_NUM(-1),
    INIT_NUM(0),
    ADD_NUM(1),
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6),
    PRICE(1_000),
}