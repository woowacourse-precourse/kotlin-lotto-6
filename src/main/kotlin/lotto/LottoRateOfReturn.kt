package lotto

import java.math.BigDecimal

class LottoRateOfReturn {
    fun calculateRateOfReturn(totalPrize: Int, amount: Int): BigDecimal {
        println(totalPrize.toDouble())
        println(amount)
        println((totalPrize.toDouble() / amount * 100).toBigDecimal())
        return (totalPrize.toDouble() / amount * 100).toBigDecimal()
    }
}