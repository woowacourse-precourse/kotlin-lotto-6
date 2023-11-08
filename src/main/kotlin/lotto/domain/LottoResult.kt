package lotto.domain

class LottoResult {
    fun calculateRateOfReturn(results: List<LottoRank>, purchasePrice: Int): Double {
        val totalPrizeMoney = results.sumOf { it.prizeMoney.replace(",", "").toInt() }
        return (totalPrizeMoney.toDouble() / purchasePrice) * 100.0
    }
}
