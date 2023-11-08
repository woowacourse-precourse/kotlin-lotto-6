package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRanking
import java.text.NumberFormat
import java.util.*

class OutputView {
    fun printLineBreaking(){
        println()
    }
    fun askPurchaseLottoAmount() {
        println("구입금액을 입력해 주세요.")
    }

    fun askLottoWinningNumbers() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun askLottoBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printLottoList(purchasedLottoCount: Int, purchasedLottoList: List<Lotto>) {
        println("${purchasedLottoCount}개를 구매했습니다.")
        purchasedLottoList.forEach { println(it.getLotto()) }
    }

    fun printWinningLottoStatistics(rateOfReturn: Double) {
        println("당첨 통계\n---")
        outputMatchingLottoRank()
        outputRateOfReturn(rateOfReturn)
    }

    private fun outputMatchingLottoRank() {
        LottoRanking.values().forEach{
            val price = it.price
            val formattedPrice = NumberFormat.getNumberInstance(Locale.US).format(price)
            println("${it.message} (${formattedPrice}원) - ${it.userLottoRankCnt}개")
        }
    }
    private fun outputRateOfReturn(rateOfReturn: Double) {
        val formattedRateOfReturn = NumberFormat.getNumberInstance(Locale.US).format(rateOfReturn)
        println("총 수익률은 $formattedRateOfReturn%입니다.")
    }
}