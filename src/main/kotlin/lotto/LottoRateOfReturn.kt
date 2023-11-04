package lotto

class LottoRateOfReturn {
    fun calculateRateOfReturn(totalPrize: Int, amount: Int): Double {
        return totalPrize.toDouble() / amount * 100
    }
}