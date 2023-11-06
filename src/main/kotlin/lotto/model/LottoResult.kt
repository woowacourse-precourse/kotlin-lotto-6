package lotto.model

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
            6 -> RANKING_1ST_INDEX
            5 -> containBonusNumber(lottoNumbers)
            4 -> RANKING_4ST_INDEX
            3 -> RANKING_5ST_INDEX
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