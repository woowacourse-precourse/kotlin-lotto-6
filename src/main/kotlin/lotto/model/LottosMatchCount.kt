package lotto.model

import lotto.dto.LottoMatchCount
import lotto.util.Match

class LottosMatchCount(
    val result: MutableMap<Int, Int> = Match.values()
        .associate { it.count to RESULT_DEFAULT_VALUE }
        .toMutableMap()
) {

    fun update(lottoMatchCount: LottoMatchCount) {
        if (lottoMatchCount.winning !in MIN_WINNING_MATCHES..MAX_WINNING_MATCHES) {
            return
        }

        var key = lottoMatchCount.winning
        if (lottoMatchCount.winning == SPECIAL_MATCH_COUNT) {
            key = Match.FIFTH.count.takeIf { lottoMatchCount.bonus == NO_BONUS_MATCH }
                ?: Match.FIFTH_BONUS.count
        }

        result[key] = result.getOrDefault(key, RESULT_DEFAULT_VALUE) + COUNT_PLUS_VALUE
    }

    companion object {
        private const val RESULT_DEFAULT_VALUE = 0
        private const val COUNT_PLUS_VALUE = 1

        private const val MIN_WINNING_MATCHES = 3
        private const val MAX_WINNING_MATCHES = 6

        private const val SPECIAL_MATCH_COUNT = 5
        private const val NO_BONUS_MATCH = 0
    }
}