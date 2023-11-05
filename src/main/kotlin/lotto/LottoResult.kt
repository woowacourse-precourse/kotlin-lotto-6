package lotto

import ui.UserOutput

class LottoResult(val winLotto: Lotto, val bonus: Int) {
    fun countWinNumbers(lotto: Lotto): Int {
        return winLotto.toAscendingList()
            .intersect(lotto.toAscendingList().toSet())
            .size
    }
    fun hasBonus(lotto: Lotto): Boolean = lotto.toAscendingList().contains(bonus)

    fun calculateWinLottos(lottos: MutableList<Lotto>): LottoResult {
        for (lotto in lottos) countPrizeRank(lotto)

        return this
    }

    private fun countPrizeRank(lotto: Lotto) {
        when (countWinNumbers(lotto)) {
            LottoPrize.FIFTH_PRIZE.value -> LottoPrize.FIFTH_PRIZE.count++
            LottoPrize.FOURTH_PRIZE.value -> LottoPrize.FOURTH_PRIZE.count++
            LottoPrize.THIRD_PRIZE.value -> countSecondOrThird(lotto)
            LottoPrize.JACKPOT.value -> LottoPrize.JACKPOT.count++
        }
    }
    private fun countSecondOrThird(lotto: Lotto) {
        if (hasBonus(lotto)) {
            LottoPrize.SECOND_PRIZE.count++
            return
        }
        LottoPrize.THIRD_PRIZE.count++
    }

    fun showWinLottoData(): LottoResult {
        UserOutput.printWinLottoResult()
        for (element in LottoPrize.entries) element.printPrizeData()

        return this
    }
    fun showProfitData(money: Int) {
        val profit: Double = (sumTotalPrizeMoney().toDouble() / money * 100)
        UserOutput.printProfitResult(profit)
    }

    private fun sumTotalPrizeMoney(): Long {
        var totalPrizeMoney: Long = 0
        for (element in LottoPrize.entries)
            totalPrizeMoney += element.calculatePrizeMoney()

        return totalPrizeMoney
    }
}
