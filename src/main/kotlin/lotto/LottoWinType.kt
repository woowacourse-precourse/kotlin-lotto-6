package lotto

enum class LottoWinType(val prize: Long, var winsNumber: Int) {

    THREE_MATCH(5000, 0),
    FOUR_MATCH(50000, 0),
    FIVE_MATCH(1500000, 0),
    FIVE_MATCH_WITH_BONUS(30000000, 0),
    SIX_MATCH(2000000000, 0);

}