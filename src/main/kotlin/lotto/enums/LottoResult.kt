package lotto.enums

enum class LottoResult(var prizeAmount: Int, val message: String) {
    NOT_MATCH(0,"일치된것 없음"),
    MATCH_THREE(5000, "3개 일치"),
    MATCH_FOUR(50000, "4개 일치"),
    MATCH_FIVE(1500000, "5개 일치"),
    MATCH_FIVE_BONUS(30000000, "5개 일치, 보너스 볼 일치"),
    MATCH_SIX(2000000000, "6개 일치")
}