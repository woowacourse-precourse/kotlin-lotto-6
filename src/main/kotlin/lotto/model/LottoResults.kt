package lotto.model

import lotto.model.dto.LottoResult
import lotto.util.Match

class LottoResults(
    var _result: MutableMap<Int, Int> = Match.values()
        .associate { it.count to RESULT_DEFAULT_VALUE }
        .toMutableMap()
) {
    val result get() = _result.toMap()

    fun update(lottoResult: LottoResult) {
        if (lottoResult.winningMatchCount !in MIN_WINNING_MATCHES..MAX_WINNING_MATCHES) {
            return
        }

        var key = lottoResult.winningMatchCount
        if (lottoResult.winningMatchCount == SPECIAL_MATCH_COUNT) {
            key = Match.FIFTH.count.takeIf { lottoResult.bonusMatchCount == NO_BONUS_MATCH } ?: Match.FIFTH_BONUS.count
        }

        _result[key] = _result.getOrDefault(key, RESULT_DEFAULT_VALUE) + 1
    }

    companion object {
        const val RESULT_DEFAULT_VALUE = 0

        private const val MIN_WINNING_MATCHES = 3
        private const val MAX_WINNING_MATCHES = 6

        private const val SPECIAL_MATCH_COUNT = 5
        private const val NO_BONUS_MATCH = 0
    }
}

