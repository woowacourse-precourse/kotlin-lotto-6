package lotto.modle

enum class LottoRank() {
    THREE_MATCH,
    FOUR_MATCH,
    FIVE_MATCH,
    FIVE_MATCH_WITH_BONUS,
    SIX_MATCH;

    private var count = 0

    fun increment() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}