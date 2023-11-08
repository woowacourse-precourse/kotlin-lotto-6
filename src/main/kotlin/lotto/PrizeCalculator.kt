package lotto

class PrizeCalculator(private val results: Map<String, Int>) {

    // 당첨 등수별 상금을 정의합니다.
    private val prizeMoney = mapOf(
        "3개 일치 (5,000원)" to 5_000,
        "4개 일치 (50,000원)" to 50_000,
        "5개 일치 (1,500,000원)" to 1_500_000,
        "5개 일치, 보너스 볼 일치 (30,000,000원)" to 30_000_000,
        "6개 일치 (2,000,000,000원)" to 2_000_000_000
    )

    // 총 상금을 계산합니다.
    fun calculateTotalPrize(): Long {
        return results.map { (key, count) ->
            prizeMoney[key]?.let { it.toLong() * count } ?: 0
        }.sum()
    }

    // 당첨 결과에 따른 상세 상금 정보를 반환합니다.
    fun getPrizeBreakdown(): Map<String, Long> {
        return results.mapValues { (key, count) ->
            prizeMoney[key]?.toLong()?.times(count) ?: 0
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): String {
        val totalPrize = calculateTotalPrize()
        val profitRate = if (purchaseAmount > 0) {
            ((totalPrize - purchaseAmount) / purchaseAmount.toDouble()) * 100
        } else {
            0.0
        }
        return "%.2f".format(profitRate)
    }
}
