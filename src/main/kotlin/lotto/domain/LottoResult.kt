package lotto.domain

class LottoResult {
    fun calculateRateOfReturn(results: List<LottoRank>, purchasePrice: Int): Double {
        val totalPrizeMoney = results.sumOf { it.prizeMoney.replace(",", "").toInt() }
        val rateOfReturn = (totalPrizeMoney.toDouble() - purchasePrice) / purchasePrice

        return if (rateOfReturn < 0) rateOfReturn * 100 else rateOfReturn
    }
}
