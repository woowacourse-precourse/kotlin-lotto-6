package lotto.model

import kotlin.math.round


class LottoResult {
    private var totalLottoPrize: Int = 0
    private var totalLottoRateOfReturn: Double = 0.0
    private var matchingLottoResult: MutableMap<LottoMatchNum, Int> = mutableMapOf(
        LottoMatchNum.THREE_MATCH to 0,
        LottoMatchNum.FOUR_MATCH to 0,
        LottoMatchNum.FIVE_MATCH to 0,
        LottoMatchNum.FIVE_PLUS_BONUS to 0,
        LottoMatchNum.SIX_MATCH to 0,
    )

    fun getTotalLottoPrize(): Int = totalLottoPrize
    fun getMatchingLottoResult(): MutableMap<LottoMatchNum, Int> = matchingLottoResult
    fun getTotalLottoRateOfReturn(): Double = totalLottoRateOfReturn
    fun setMatchingLottoResult(lottoMatchNum: LottoMatchNum) {
        if (matchingLottoResult.containsKey(lottoMatchNum)) {
            val currentValue = matchingLottoResult[lottoMatchNum]
            matchingLottoResult[lottoMatchNum] = currentValue!! + 1
        }
    }

    fun calculateTotalLottoPrize() {
        val lottoPrize = LottoPrize()
        matchingLottoResult.forEach { (matchNum, matchResult) ->
            val prize = lottoPrize.winningsPrizeMap[matchNum]
            // 다른 방법이 없을까?
            if (prize != null) {
                totalLottoPrize += prize * matchResult
            }
        }
    }

    fun calculateLottoReturnOfRate(lottoPurchaseMount: Int) {
        totalLottoRateOfReturn = roundNumber((1 + ((totalLottoPrize - lottoPurchaseMount).toDouble() / lottoPurchaseMount)) * 100)
    }

    private fun roundNumber(num: Double): Double {
        return round(num * 10) / 10
    }
}