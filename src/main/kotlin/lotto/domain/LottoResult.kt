package lotto.domain

class LottoResult {
    private fun computeTotalPrizeMoney(result: Map<Rank, Int>): Int {
        return result.entries.sumOf { it.key.prize * it.value }
    }
    fun computeGrossProfit(result: Map<Rank, Int>, initialCapital:Int):Float{
        val totalPrize = computeTotalPrizeMoney(result).toFloat()
        return totalPrize/initialCapital.toFloat()
    }
}