package lotto.domain

// 각 로또의 결과
enum class LottoResult(val prize: Int, private val message: String) {
    MISS(0, "꽝"),
    THREE_MATCH(5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(200000000, "6개 일치 (2,000,000,000원)");

    companion object {
        fun of(countOfMatch: Int, isBonusMatch: Boolean): LottoResult {
            return when {
                countOfMatch == 6 -> SIX_MATCH
                countOfMatch == 5 && isBonusMatch -> FIVE_MATCH_WITH_BONUS
                countOfMatch == 5 -> FIVE_MATCH
                countOfMatch == 4 -> FOUR_MATCH
                countOfMatch == 3 -> THREE_MATCH
                else -> MISS
            }
        }
    }

    fun getMessage(count: Int): String {
        return "$message - ${count}개"
    }
}