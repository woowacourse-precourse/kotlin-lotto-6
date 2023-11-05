package lotto.model


class LottoResult {
    private var totalLottoPrize: Int = 0
    private var matchingLottoResult: Map<LottoMatchNum, Int> = mapOf(
        LottoMatchNum.THREE_MATCH to 0,
        LottoMatchNum.FOUR_MATCH to 0,
        LottoMatchNum.FIVE_MATCH to 0,
        LottoMatchNum.FIVE_PLUS_BONUS to 0,
        LottoMatchNum.SIX_MATCH to 0
    )

    fun getTotalLottoPrize(): Int {
        return totalLottoPrize
    }

    fun getMatchingLottoResult(): Map<LottoMatchNum, Int> {
        return matchingLottoResult
    }

    fun calculateTotalLottoPrize() {
        val lottoPrize = LottoPrize()
        matchingLottoResult.forEach { (matchNum, matchResult) ->
            val prize = LottoPrize().winningsPrizeMap[matchNum]
            // 다른 방법이 없을까?
            if (prize != null) {
                totalLottoPrize += prize * matchResult
            }
        }
    }
}