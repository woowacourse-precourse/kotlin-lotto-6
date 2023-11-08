package lotto

import ui.InputValidator
import ui.UserInput
import ui.UserOutput

const val MSG_ERR_LOTTO_BUY_FIRST = "[ERROR] 로또를 먼저 발행해 주세요"

class LottoResult(
    private val winLotto: Lotto = Lotto(UserInput.readWinNumbers()),
    private val bonus: Int = UserInput.readBonusNumber(existingNumbers = winLotto.toAscendingList())
) {

    init {
        InputValidator
            .checkProperNumbersSize(winLotto.toAscendingList())
            .checkNumberListInRange(winLotto.toAscendingList())
            .checkNumberInRange(bonus)
            .checkIsExistingNumber(bonus, winLotto.toAscendingList())
    }

    fun countWinNumbers(lotto: Lotto): Int {
        return winLotto.toAscendingList()
            .intersect(lotto.toAscendingList().toSet())
            .size
    }

    fun hasBonus(lotto: Lotto): Boolean = lotto.toAscendingList().contains(bonus)

    fun calculateWinLottos(lottos: MutableList<Lotto>): LottoResult {
        if (lottos.size == 0) throw IllegalStateException(MSG_ERR_LOTTO_BUY_FIRST)

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

    inner class LottoResultShow(private val money: Int) {

        fun showWinLottoData() {
            UserOutput.printWinLottoResult()
            for (element in LottoPrize.entries) element.printPrizeData()
        }

        fun showProfitData() = UserOutput.printProfitResult(calculateProfit(money))

        private fun calculateProfit(money: Int): Double = sumTotalPrizeMoney().toDouble() / money * 100
        private fun sumTotalPrizeMoney() = LottoPrize.entries.sumOf { it.calculatePrizeMoney() }

    }
}
