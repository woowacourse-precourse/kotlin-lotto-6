package lotto

class LottoResult() {

    lateinit var winLotto: Lotto
    var bonus = 0

    fun countWinNumbers(lotto: Lotto): Int {
        return winLotto.toAscendingList()
            .intersect(lotto.toAscendingList().toSet())
            .size
    }
    fun hasBonus(lotto: Lotto): Boolean = lotto.toAscendingList().contains(bonus)

    fun calculateWinLottos(lottos: MutableList<Lotto>) {
        for (lotto in lottos) {
            when (countWinNumbers(lotto)) {
                LottoPrize.FIFTH_PRIZE.value -> LottoPrize.FIFTH_PRIZE.count++
                LottoPrize.FOURTH_PRIZE.value -> LottoPrize.FOURTH_PRIZE.count++
                LottoPrize.THIRD_PRIZE.value -> countSecondOrThird(lotto)
                LottoPrize.JACKPOT.value -> LottoPrize.JACKPOT.count++
            }
        }
    }
    private fun countSecondOrThird(lotto: Lotto) {
        if (hasBonus(lotto)) {
            LottoPrize.SECOND_PRIZE.count++
            return
        }
        LottoPrize.THIRD_PRIZE.count++
    }
}
