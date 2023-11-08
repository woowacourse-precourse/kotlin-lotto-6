package lotto

enum class Reward(val matchedCount: Int, val bonus: Boolean, val money: String) {
    FIRST(6, false, "2,000,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FOURTH(4, false, "50,000"),
    FIFTH(3, false, "5,000");

    companion object {
        private const val INPUT_EXCEPTION = "[ERROR] 순위를 입력해 주세요."
        fun getRank(cnt: Int, bonus: Boolean): String {
            return when {
                cnt == FIRST.matchedCount -> "FIRST"
                cnt == SECOND.matchedCount && bonus == SECOND.bonus -> "SECOND"
                cnt == THIRD.matchedCount -> "THIRD"
                cnt == FOURTH.matchedCount -> "FOURTH"
                cnt == FIFTH.matchedCount -> "FIFTH"
                else -> "NOTHING"
            }
        }

        fun getPrizeMoney(rank: String): String {
            return when (rank) {
                "FIRST" -> FIRST.money
                "SECOND" -> SECOND.money
                "THIRD" -> THIRD.money
                "FOURTH" -> FOURTH.money
                "FIFTH" -> FIFTH.money
                else -> throw IllegalArgumentException(INPUT_EXCEPTION)
            }
        }

        fun getSameCount(rank: String): Int {
            return when (rank) {
                "FIRST" -> FIRST.matchedCount
                "SECOND" -> SECOND.matchedCount
                "THIRD" -> THIRD.matchedCount
                "FOURTH" -> FOURTH.matchedCount
                "FIFTH" -> FIFTH.matchedCount
                else -> throw IllegalArgumentException(INPUT_EXCEPTION)
            }
        }
    }

}