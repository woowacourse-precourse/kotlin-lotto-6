package lotto

import ui.InputValidator
import ui.UserInput
import ui.UserOutput

class LottoResult(val winLotto: Lotto, val bonus: Int) {

    init {
        InputValidator
            .checkProperNumbersSize(winLotto.toAscendingList())
            .checkNumberListInRange(winLotto.toAscendingList())
            .checkNumberInRange(bonus)
            .checkIsDuplicateNumber(bonus, winLotto.toAscendingList())
    }
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
    fun showProfitData(money: Int) = UserOutput.printProfitResult(calculateProfit(money))

    private fun calculateProfit(money: Int): Double = sumTotalPrizeMoney().toDouble() / money * 100

    private fun sumTotalPrizeMoney(): Long {
        var totalPrizeMoney: Long = 0
        for (element in LottoPrize.entries)
            totalPrizeMoney += element.calculatePrizeMoney()

        return totalPrizeMoney
    }
}
