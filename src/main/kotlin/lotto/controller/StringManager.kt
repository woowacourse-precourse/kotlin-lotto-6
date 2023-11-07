package lotto.controller

import lotto.utils.Messages

class StringManager {
    fun formatNumberWithComma(number: Int): String {
        return "%,d".format(number)
    }

    fun formatPercentage(profitPercentage: Double): String {
        return String.format(Messages.PROFIT_MESSAGE, profitPercentage)
    }
}