package lotto.domain.util

class MathHelper {
    fun calculateWinRate(totalAmount: Int, ticketCount: Int): Float =
        (totalAmount.toFloat() / (ticketCount * TICKET_PRICE).toFloat()) * PERCENTAGE

    fun roundToFirstDecimalPlace(input: Float): String =
        String.format(ROUND_TO_FIRST_DECIMAL_PLACE, input)

    companion object {
        const val ROUND_TO_FIRST_DECIMAL_PLACE = "%.1f"
        const val TICKET_PRICE = 1000
        const val PERCENTAGE = 100
    }
}