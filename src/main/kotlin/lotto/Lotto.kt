package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }
    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}
enum class LottoResult(val matchCount: Int, val prize: Int) {
    NONE(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000);

    companion object {
        fun fromMatchCount(matchCount: Int): LottoResult {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}