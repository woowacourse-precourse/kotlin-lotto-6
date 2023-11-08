package lotto.model
import kotlin.math.round

class LottoBank {

    fun getRateOfReturn(purchaseLottoCount: Int): Double {
        val purchaseLottoAmount = purchaseLottoCount * 1000
        val winningLottoAmount = calculateWinningLottoAmount()
        val rateOfReturn = (winningLottoAmount.toDouble() / purchaseLottoAmount.toDouble())*100
        return round(rateOfReturn * 10.0) / 10.0
    }

    private fun calculateWinningLottoAmount(): Int {
        var winningLottoAmount = 0
        LottoRanking.values().forEach {
            winningLottoAmount += it.price * it.userLottoRankCnt
        }
        return winningLottoAmount
    }
}