package lotto.constants

import lotto.utils.convertWithDigitComma

enum class WinningResult(val matchingCount: Int, val amount: Int) {
    NOT_WINNING(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    override fun toString() = amount.convertWithDigitComma()
}