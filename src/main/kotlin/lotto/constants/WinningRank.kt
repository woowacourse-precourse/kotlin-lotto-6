package lotto.constants

import lotto.utils.convertWithDigitComma

enum class WinningRank(private val matchingCount: Int, val amount: Int) {
    NOT_WINNING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    override fun toString(): String {
        val bonusMessage = if (this == SECOND) BONUS_MESSAGE else ""
        val amountMessage = amount.convertWithDigitComma()
        return "${matchingCount}개 일치$bonusMessage (${amountMessage}원)"
    }

    companion object {
        private const val BONUS_MESSAGE = ", 보너스 볼 일치"
    }
}