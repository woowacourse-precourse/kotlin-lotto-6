package lotto

enum class LottoWinType(val prize: Long) {

    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_MATCH_WITH_BONUS(30000000),
    SIX_MATCH(2000000000);

}