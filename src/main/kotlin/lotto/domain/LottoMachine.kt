package lotto.domain

import lotto.util.Const
import lotto.io.UserInterface
import lotto.model.LottoRank
import lotto.model.User
import lotto.model.WinningLotto
import java.text.DecimalFormat

class LottoMachine(
    private val user: User,
    private val winningLotto: WinningLotto,
) {
    fun playLotto() {
        val result = calculateMyResult()
        val totalProfit = getTotalProfit(result)
        val rates = getProfitRate(totalProfit, user.getAmount())

        showMyResult(result, rates)

    }

    private fun calculateMyResult(): Map<LottoRank, Int> {
        return user.compareToWinningLotto(winningLotto.numbers, winningLotto.bonusNumber)

    }

    private fun getTotalProfit(lottoResults: Map<LottoRank, Int>): Int {
        var totalProfit = Const.ZERO
        for (result in lottoResults) {
            totalProfit += (result.value * result.key.prize)
        }
        return totalProfit
    }

    private fun getProfitRate(totalProfit: Int, purchaseAmount: Int): String {
        val rates = totalProfit * 100.0 / purchaseAmount.toDouble()
        val df = DecimalFormat("###,##0.0")
        return df.format(rates)
    }

    private fun showMyResult(result: Map<LottoRank, Int>, profitRate: String) {
        val ui = UserInterface()
        ui.showMyResult(result, profitRate)
    }


}