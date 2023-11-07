package lotto.model

import lotto.util.Constants.MATCH_FIVE_WINNING
import lotto.util.Constants.MATCH_FOUR_WINNING
import lotto.util.Constants.MATCH_SIX_WINNING
import lotto.util.Constants.MATCH_THREE_WINNING
import lotto.util.Constants.RANKING_1ST_INDEX
import lotto.util.Constants.RANKING_2ST_INDEX
import lotto.util.Constants.RANKING_3ST_INDEX
import lotto.util.Constants.RANKING_4ST_INDEX
import lotto.util.Constants.RANKING_5ST_INDEX
import lotto.util.Constants.RANKING_NOTHING

class LottoResult(
    private val winningNumbers: List<Int>,
    private val bonus: Int
) {
    fun calculateRanking(lottoNumbers: List<Int>): Int {
        val matchingCount = lottoNumbers.intersect(winningNumbers.toSet()).count()
        return when (matchingCount) {
            MATCH_SIX_WINNING -> RANKING_1ST_INDEX
            MATCH_FIVE_WINNING -> containBonusNumber(lottoNumbers)
            MATCH_FOUR_WINNING -> RANKING_4ST_INDEX
            MATCH_THREE_WINNING -> RANKING_5ST_INDEX
            else -> RANKING_NOTHING
        }
    }

    private fun containBonusNumber(lottoNumbers: List<Int>): Int {
        return when (lottoNumbers.contains(bonus)) {
            true -> RANKING_2ST_INDEX
            false -> RANKING_3ST_INDEX
        }
    }
}