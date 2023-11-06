package lotto

import java.text.NumberFormat
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){ "로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 번호는 중복될 수 없습니다." }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun getLottoResult(winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
        val matchCount = matchCount(winningNumbers)
        val isBonus = contains(bonusNumber)
        return LottoResult.fromMatchCount(matchCount, isBonus)
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}
enum class LottoResult(val matchCount: Int, val prize: Int, val isBonus: Boolean = false) {
    NONE(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000),
    FIVE_MATCHES_AND_BONUS(5, 30000000, true);

    companion object {
        fun fromMatchCount(matchCount: Int, isBonus: Boolean): LottoResult {
            return values().find { it.matchCount == matchCount && it.isBonus == isBonus } ?: NONE
        }
    }

    fun getFormattedResult(count: Int): String {
        return when(this) {
            FIVE_MATCHES_AND_BONUS -> "${matchCount}개 일치, 보너스 볼 일치 (${NumberFormat.getNumberInstance().format(prize)}원) - ${count}개"
            FIVE_MATCHES -> "${matchCount}개 일치 (${NumberFormat.getNumberInstance().format(prize)}원) - ${count}개"
            FOUR_MATCHES -> "${matchCount}개 일치 (${NumberFormat.getNumberInstance().format(prize)}원) - ${count}개"
            THREE_MATCHES -> "${matchCount}개 일치 (${NumberFormat.getNumberInstance().format(prize)}원) - ${count}개"
            SIX_MATCHES -> "${matchCount}개 일치 (${NumberFormat.getNumberInstance().format(prize)}원) - ${count}개"
            NONE -> ""
        }
    }
}