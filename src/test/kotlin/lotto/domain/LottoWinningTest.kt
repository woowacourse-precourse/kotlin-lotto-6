package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoWinningTest {
    @Test
    fun `로또 구매 금액과 로또 번호 일치 정도로 수익률 구한다`() {
        val amount = 8000
        val winning = mutableListOf<Int>(3, 0, 3, 0, 0, 0, 3, 3)
        val winningCount = winning.count { it == 3 }
        val bonus = 1
        val profit = LottoWinning(winning, bonus).profit(amount)
        val result = 5000 * winningCount
        assertTrue(profit != String.format("%.1f", result.toDouble() / amount * 100) + "%")
    }
}