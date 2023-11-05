package domain

class LottoResult(
    private val checkPrize: Array<Int> = Array(PRIZE_COUNT) { 0 },
    private val purchaseLotto: List<Lotto>,
    private val lottoPrizeCheck: LottoPrizeCheck
) {
    fun lottoResult(): Array<Int> {
        purchaseLotto.forEach { prize ->
            val prizeResultIndex = lottoPrizeCheck.checkPrize(prize)
            if(prizeResultIndex != LottoPrizeCheck.INDEX_NOTHING) checkPrize[prizeResultIndex]++
        }
        return checkPrize
    }

    companion object {
        private const val PRIZE_COUNT = 5
    }
}