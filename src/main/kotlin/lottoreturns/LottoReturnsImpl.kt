package lottoreturns

import lottopurchaseamount.LottoPurchaseAmount
import lottoranking.LottoRanking
import kotlin.math.round

class LottoReturnsImpl : LottoReturns {
    override fun calculate(lottoPurchaseAmount: LottoPurchaseAmount): Double {
        var totalWinningAmount = 0.0

        LottoRanking.entries.forEach {
            totalWinningAmount += it.count * it.reward
        }

        return round((totalWinningAmount * 100) / lottoPurchaseAmount.money)
    }
}