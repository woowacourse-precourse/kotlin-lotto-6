package lotto.model


class LottoResult {
    private var totalLottoPrize: Int = 0
    private var matchingLottoResult: MutableMap<LottoMatchNum, Int> = mutableMapOf(
        LottoMatchNum.THREE_MATCH to 0,
        LottoMatchNum.FOUR_MATCH to 0,
        LottoMatchNum.FIVE_MATCH to 0,
        LottoMatchNum.FIVE_PLUS_BONUS to 0,
        LottoMatchNum.SIX_MATCH to 0
    )

    fun getTotalLottoPrize(): Int {
        return totalLottoPrize
    }

    fun getMatchingLottoResult(): MutableMap<LottoMatchNum, Int> {
        return matchingLottoResult
    }

    fun setMatchingLottoResult(matchingLottoNumCount: List<Int>) {
        val matchingLottoMatchNum = LottoMatchNum.values()

        matchingLottoMatchNum.forEachIndexed { index, lottoMatchNum ->
            matchingLottoResult[lottoMatchNum] = matchingLottoNumCount[index]
        }
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