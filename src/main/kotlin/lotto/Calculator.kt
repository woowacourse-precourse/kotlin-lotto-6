package lotto

class Calculator(
    private var purchaseCost: Int = 0
) {

    fun calculateLottoAvailableForPurchase(number: Int): Int {
        purchaseCost = number
        return (purchaseCost / 1000)
    }

    fun calculateYieldResult(types: List<LottoWinType>): String {
        val profits = types.sumOf { it.prize }
        val yield = (profits.toDouble() / purchaseCost * 100).takeIf { it.isFinite() } ?: 0.0
        val formattedYield = String.format("%.1f%%", yield)

        return formattedYield
    }

}