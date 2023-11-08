package lotto.model

import lotto.Constants.MIN_NUMBER

enum class LottoRank() {
    THREE_MATCH,
    FOUR_MATCH,
    FIVE_MATCH,
    FIVE_MATCH_WITH_BONUS,
    SIX_MATCH;

    private var count = MIN_NUMBER

    fun increment() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}