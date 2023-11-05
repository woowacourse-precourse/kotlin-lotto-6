package lotto.model

class LottoResults {
    private val lottoResults: List<LottoResult> = LottoPrize.entries.map { LottoResult(it) }

    fun makeLottoResults(lottoPrizes: List<LottoPrize?>) {
        lottoPrizes.forEach { lottoPrize ->
            lottoResults.firstOrNull {
                it.prize == lottoPrize
            }?.increasePrizeCount()
        }
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

    fun getTotalMoney(): Long {
        var totalMoney = 0L
        lottoResults.forEach {
            totalMoney += it.prize.money * it.resultCount
        }
        return totalMoney
    }
}