package lotto

class Calculator() {
    fun calculateRateReturn(rank: List<Int>, money: Int): String {

        val returnMoney = (PriceHowManyMatch.일치3개.priceReturn() * rank[0]
                + PriceHowManyMatch.일치4개.priceReturn() * rank[1]
                + PriceHowManyMatch.일치5개.priceReturn() * rank[2]
                + PriceHowManyMatch.일치5개보너스.priceReturn() * rank[3]
                + PriceHowManyMatch.일치6개.priceReturn() * rank[4])

        return String.format("%.1f", returnMoney * 100.0 / money)
    }

}

enum class PriceHowManyMatch(private val price: Int) {
    일치3개(5000),
    일치4개(50000),
    일치5개(1500000),
    일치5개보너스(30000000),
    일치6개(2000000000);

    fun priceReturn() = price
}