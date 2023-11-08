package lotto

enum class MatchedCount(val title: String, val prize: Long, val description: String) {
    FIFTH("5등", 5_000, "3개 일치"),
    FOURTH("4등", 50_000, "4개 일치"),
    THIRD("3등", 1_500_000, "5개 일치"),
    SECOND("2등", 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST("1등", 2_000_000_000, "6개 일치"),

    NONE("낙첨", 0, "2개 이하 일치");

    companion object {
        fun fromMatchedNumbers(matchedNumbers: Int, isBonusNumberMatched: Boolean): MatchedCount {
            return when (matchedNumbers) {
                6 -> FIRST
                5 -> if (isBonusNumberMatched) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}