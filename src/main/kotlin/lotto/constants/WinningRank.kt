package lotto.constants

import lotto.utils.convertWithDigitComma

enum class WinningRank(private val matchingCount: Int, val amount: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOT_WINNING(0, 0);

    override fun toString(): String {
        val bonusMessage = if (this == SECOND) ", 보너스 볼 일치" else ""
        val amountMessage = amount.convertWithDigitComma()
        return "${matchingCount}개 일치$bonusMessage (${amountMessage}원)"
    }
}