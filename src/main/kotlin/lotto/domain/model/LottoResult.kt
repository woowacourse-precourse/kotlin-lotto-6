package lotto.domain.model

class LottoResult(val result: Map<Rank, Int>) {

    private fun getTotalPrize(): Float {
        return result.map { it.key.getPrize() * it.value }.sum().toFloat()
    }

    fun calculatePerformance(purchase: Purchase): Float {
        val totalPrize = getTotalPrize()
        if (totalPrize == 0F) {
            return totalPrize
        }
        return (totalPrize / purchase.amount) * 100
    }
}
