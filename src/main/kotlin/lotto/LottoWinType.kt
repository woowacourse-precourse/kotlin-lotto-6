package lotto

enum class LottoWinType(val prize: Long, val description : String) {

    THREE_MATCH(5000,"3개 일치"),
    FOUR_MATCH(50000,"4개 일치"),
    FIVE_MATCH(1500000,"5개 일치"),
    FIVE_MATCH_WITH_BONUS(30000000,"5개 일치, 보너스 볼 일치"),
    SIX_MATCH(2000000000,"6개 일치");

}