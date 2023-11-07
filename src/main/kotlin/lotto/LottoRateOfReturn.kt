package lotto

import java.math.BigDecimal

class LottoRateOfReturn {
    companion object {
        private const val ONE_HUNDRED = 100
    }
    fun calculateRateOfReturn(totalPrize: BigDecimal, amount: Int): BigDecimal {
        return (totalPrize.toDouble() / amount * ONE_HUNDRED).toBigDecimal()
    }
}