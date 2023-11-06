package lotto

class Calculator {

    fun calculateLottoAvailableForPurchase(number: Int): Int {
        return (number / 1000)
    }

    fun calculateYieldResult(purchaseCost: Int, types: List<LottoWinType>): String {
        val profits = types.sumOf { it.prize }
        val yield = (profits.toDouble() / purchaseCost * 100).takeIf { it.isFinite() } ?: 0.0
        val formattedYield = String.format("%.2f", yield)

        return "${formattedYield}%"
    }

}