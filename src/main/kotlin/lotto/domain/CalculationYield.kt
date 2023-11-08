package lotto.domain

class CalculationYield {
    fun calculateYield(winAmount: Int, buyamount: Int): Int{
        var yield = (winAmount/buyamount)*100
        return yield
    }
}