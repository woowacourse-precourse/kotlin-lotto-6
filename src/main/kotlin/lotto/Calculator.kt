package lotto

class Calculator(
    private var purchaseCost: Int = 0
) {

    fun calculateLottoAvailableForPurchase(input: Int): Int {
        purchaseCost = input
        return (purchaseCost / 1000)
    }

    fun calculateYieldResult(lottoWinTypes: List<LottoWinType>): String {
        val profits = lottoWinTypes.sumOf { it.prize }
        val yield = (profits.toDouble() / purchaseCost * 100).takeIf { it.isFinite() } ?: 0.0

        return String.format("%.1f%%", yield)
    }

}