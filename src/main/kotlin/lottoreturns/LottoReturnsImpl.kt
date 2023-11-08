package lottoreturns

import lottopurchaseamount.LottoPurchaseAmount
import lottoranking.LottoRanking
import kotlin.math.round

class LottoReturnsImpl : LottoReturns {
    override fun calculate(lottoPurchaseAmount: LottoPurchaseAmount): Double {
        var totalWinningAmount = ZERO

        LottoRanking.entries.forEach {
            totalWinningAmount += it.count * it.reward
        }

        return round((totalWinningAmount * THOUSAND) / lottoPurchaseAmount.money) / TEN
    }

    companion object {
        private const val ZERO = 0.0
        private const val THOUSAND = 1_000
        private const val TEN = 10.0
    }
}