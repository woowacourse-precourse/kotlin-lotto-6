package lotto.model


class LottoResult {
    private var totalLottoPrize: Int = 0
    private var matchingLottoResult: MutableMap<LottoMatchNum, Int> = mutableMapOf(
        LottoMatchNum.THREE_MATCH to 0,
        LottoMatchNum.FOUR_MATCH to 0,
        LottoMatchNum.FIVE_MATCH to 0,
        LottoMatchNum.FIVE_PLUS_BONUS to 0,
        LottoMatchNum.SIX_MATCH to 0,
        LottoMatchNum.EXTRA to 0,
        LottoMatchNum.ERROR to 0
    )

    fun getTotalLottoPrize(): Int = totalLottoPrize
    fun getMatchingLottoResult(): MutableMap<LottoMatchNum, Int> = matchingLottoResult
    fun setMatchingLottoResult(lottoMatchNum: LottoMatchNum) {
        matchingLottoResult[lottoMatchNum] = matchingLottoResult[lottoMatchNum]!! + 1
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
}