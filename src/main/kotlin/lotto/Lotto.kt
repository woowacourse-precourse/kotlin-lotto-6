package lotto

import java.text.NumberFormat
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
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

    fun getFormattedPrize(): String {
        return NumberFormat.getNumberInstance().format(prize)
    }
}

