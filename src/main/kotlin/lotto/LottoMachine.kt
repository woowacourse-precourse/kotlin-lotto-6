package lotto

import lotto.io.UserInterface
import java.text.DecimalFormat

class LottoMachine(
    private val user: User,
    private val winningLotto: WinningLotto,
) {
    fun playLotto() {
        val ui = UserInterface()
        val result = calculateMyResult()
        val totalProfit = getTotalProfit(result)
        val rates = getProfitRate(totalProfit,user.getAmount())
        ui.showMyResult(result,rates)

    }
    fun calculateMyResult():Map<LottoRank,Int> {
        return user.compareToWinningLotto(winningLotto.numbers,winningLotto.bonusNumber)

    }
    private fun getTotalProfit(lottoResults:Map<LottoRank,Int>):Int {
        var totalProfit = 0
        for(result in lottoResults) {
            totalProfit += (result.value * result.key.prize)
        }
        return totalProfit
    }
    fun getProfitRate(totalProfit: Int, purchaseAmount: Int): String {
        val rates = totalProfit * 100.0 / purchaseAmount.toDouble()
        val df = DecimalFormat("###,###.0")
        return df.format(rates)
    }
    private fun showMyResult(result:Map<LottoRank,Int>, totalProfit:String) {
        val ui =UserInterface()
        ui.showMyResult(result, totalProfit)
    }


}