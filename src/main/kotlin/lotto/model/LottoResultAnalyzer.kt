package lotto.model

import lotto.util.Constants.MATCH_FIVE
import lotto.util.Constants.MATCH_FIVE_BONUS
import lotto.util.Constants.MATCH_FOUR
import lotto.util.Constants.MATCH_SIX
import lotto.util.Constants.MATCH_THREE
import lotto.util.Constants.PERCENTAGE_MULTIPLIER
import java.math.BigDecimal
import java.math.RoundingMode

class LottoResultAnalyzer {
    val analyzedLottoResults: List<Int>
        get() = _analyzedLottoResults

    private var _analyzedLottoResults = MutableList(5) { 0 }

    private var _profit = 0

    val profitRate: Double
        get() = _profitRate
    private var _profitRate: Double = 0.0

    fun analyzeLottoResults(result: List<Int>) {
        result.forEach { analyzeNumber(it) }
    }

    private fun analyzeNumber(number: Int) {
        when (number) {
            MATCH_THREE -> _analyzedLottoResults[0]++
            MATCH_FOUR -> _analyzedLottoResults[1]++
            MATCH_FIVE -> _analyzedLottoResults[2]++
            MATCH_FIVE_BONUS -> _analyzedLottoResults[3]++
            MATCH_SIX -> _analyzedLottoResults[4]++
        }
    }


    private fun sumProfit() {
        val (threeMatch, fourMatch, fiveMatch, fiveBonusMatch, sixMatch) = _analyzedLottoResults
        _profit =
            threeMatch * THREE_MATCH_PRIZE + fourMatch * FOUR_MATCH_PRIZE + fiveMatch * FIVE_MATCH_PRIZE + fiveBonusMatch * FIVE_BONUS_MATCH_PRIZE + sixMatch * SIX_MATCH_PRIZE
    }

    fun calculateProfitRate(purchaseAmount: Int) {
        sumProfit()
        val divResult = _profit.toDouble().div(purchaseAmount)
        val rate = BigDecimal(divResult).setScale(2, RoundingMode.HALF_DOWN).toDouble() * PERCENTAGE_MULTIPLIER
        _profitRate = rate
    }

    companion object {
        private const val THREE_MATCH_PRIZE = 5000
        private const val FOUR_MATCH_PRIZE = 50000
        private const val FIVE_MATCH_PRIZE = 1500000
        private const val FIVE_BONUS_MATCH_PRIZE = 30000000
        private const val SIX_MATCH_PRIZE = 2000000000

    }
}