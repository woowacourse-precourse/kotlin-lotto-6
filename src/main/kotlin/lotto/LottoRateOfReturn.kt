package lotto

import java.math.BigDecimal

class LottoRateOfReturn {
    fun calculateRateOfReturn(totalPrize: Int, amount: Int): BigDecimal {
        return (totalPrize.toDouble() / amount * 100).toBigDecimal()
    }
}