package lotto.model

class LottoResult(val prize: LottoPrize) {
    var resultCount = 0
        private set

    fun increasePrizeCount() {
        resultCount++
    }

}