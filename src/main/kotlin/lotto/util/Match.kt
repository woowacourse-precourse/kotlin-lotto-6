package lotto.util

import java.lang.IllegalArgumentException
import javax.swing.ComponentInputMap

enum class Match(val count: Int, val info: String, val amount: String) {
    THIRD(3, "3개 일치", "5,000"),
    FOURTH(4, "4개 일치", "50,000"),
    FIFTH(50, "5개 일치", "1,500,000"),
    FIFTH_BONUS(51, "5개 일치, 보너스 볼 일치", "30,000,000"),
    SIX(6, "6개 일치", "2,000,000,000");

    companion object {
        fun findByCount(count: Int): Match? {
            return values().firstOrNull { it.count == count }
        }

        fun getAmountForCount(count: Int): Long {
            val count = findByCount(count)?.amount
                ?: throw IllegalArgumentException(NO_MATCH_FOUND_FOR_COUNT.format(count))

            return count.replace(COMMA, "").toLong()
        }

        private const val COMMA = ","
        private const val NO_MATCH_FOUND_FOR_COUNT = "count: %d와 일치하는 항목을 찾을 수 없습니다."

    }
}