package lotto.model

class LottoResults(lottoPrizes: List<LottoPrize>) {
    private val lottoResults: List<LottoResult> = LottoPrize.entries.map { LottoResult(it) }
    val totalMoney: Long
        get() {
            return lottoResults.fold(0L) { total, lottoResult ->
                total + lottoResult.prize.money * lottoResult.resultCount
            }
        }

    init {
        lottoPrizes.forEach { lottoPrize ->
            lottoResults.first {
                it.prize == lottoPrize
            }.increasePrizeCount()
        }
    }

    fun getResultState(): List<LottoResultState> {
        return lottoResults.filter { it.prize != LottoPrize.NOTING }.map {
            LottoResultState(
                it.prize.prizeCount,
                it.prize.money,
                it.prize.bonus,
                it.resultCount
            )
        }
    }
}