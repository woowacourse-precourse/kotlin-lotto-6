package lotto.model

class LottoResults(lottoPrizes: List<LottoPrize>) {
    private val lottoResults: List<LottoResult> = LottoPrize.entries.map { LottoResult(it) }

    init {
        lottoPrizes.forEach { lottoPrize ->
            lottoResults.first {
                it.prize == lottoPrize
            }.increasePrizeCount()
        }
    }

    val totalMoney: Long
        get() {
            var totalMoney = 0L
            lottoResults.forEach {
                totalMoney += it.prize.money * it.resultCount
            }
            return totalMoney
        }

    fun getResultState(): List<LottoResultState> {
        return lottoResults.map {
            LottoResultState(
                it.prize.prizeCount,
                it.prize.money,
                it.prize.bonus,
                it.resultCount
            )
        }
    }
}