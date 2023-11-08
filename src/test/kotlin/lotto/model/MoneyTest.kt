package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class MoneyTest {
    @Test
    fun `구입 금액은 음수이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(-1000)
        }
    }

    @Test
    fun `구입 금액은 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Money(1234)
        }
    }

    @Test
    fun `수익률을 계산한다`() {
        val money = Money(8000)
        val winningStatistic = HashMap<WinningRank, Int>()
        winningStatistic[WinningRank.FIFTH] = 1
        assertThat(money.calculateEarningsRate(winningStatistic)).isEqualTo(62.5f)
    }
}