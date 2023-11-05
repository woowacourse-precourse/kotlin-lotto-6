package domain

class LottoRateOfReturn(
    val checkPrize: Array<Int>,
    private val amount: Int
) {
    fun rateOfReturn(): String = getTotalPrize().calculateRateOfReturn()

    private fun getTotalPrize(): Int {
        var myTotalPrize = 0
        checkPrize.forEachIndexed { index, prize ->
            myTotalPrize += when (index) {
                0 -> WINNING_FIFTH_PLACE * prize
                1 -> WINNING_FOURTH_PLACE * prize
                2 -> WINNING_THIRD_PLACE * prize
                3 -> WINNING_SECOND_PLACE * prize
                else -> WINNING_FIRST_PLACE * prize
            }
        }
        return myTotalPrize
    }

    private fun Int.calculateRateOfReturn(): String {
        return "${ROUND_TO_TWO_DECIMALS.format ((this.toFloat() / amount.toFloat()) * 100)}${PERCENTAGE}"
    }

    companion object {
        private const val WINNING_FIRST_PLACE = 2000000000
        private const val WINNING_SECOND_PLACE = 30000000
        private const val WINNING_THIRD_PLACE = 1500000
        private const val WINNING_FOURTH_PLACE = 50000
        private const val WINNING_FIFTH_PLACE = 5000

        private const val ROUND_TO_TWO_DECIMALS = "%.1f"
        private const val PERCENTAGE = "%"
    }
}