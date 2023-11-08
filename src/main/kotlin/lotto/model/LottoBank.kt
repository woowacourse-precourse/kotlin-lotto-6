package lotto.model
import kotlin.math.round

class LottoBank {

    fun getRateOfReturn(purchaseLottoAmount: Int): Double {
        val winningLottoAmount = calculateWinningLottoAmount()
        val rateOfReturn = winningLottoAmount.toDouble() / purchaseLottoAmount.toDouble()
        return round((rateOfReturn * 10) / 10)
    }

    private fun calculateWinningLottoAmount(): Int {
        var winningLottoAmount = 0
        LottoRanking.values().forEach {
            winningLottoAmount += it.price * it.userLottoRankCnt
        }
        return winningLottoAmount
    }
}