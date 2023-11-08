package lottoreturns

import lottopurchaseamount.LottoPurchaseAmount

fun interface LottoReturns {
    fun calculate(lottoPurchaseAmount: LottoPurchaseAmount): Double
}
