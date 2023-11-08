package lotto.model

import lotto.model.seller.Ticket
import lotto.model.seller.toMoney
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizeCalculatorTest {

    @Test
    fun `로또 5개를 구매하여 5등에 당첨되었을 때, 수익률이 100%이다`() {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        val ticket = Ticket(lottos = listOf(lotto), cost = 5000.toMoney())

        val winningNumbers = Lotto.of(1, 2, 3, 10, 11, 12)
        val calculator = LottoPrizeCalculator(winningNumbers, Bonus.of("7", winningNumbers))
        val result = calculator.issueLottoResultReceipt(ticket)

        assertThat(result.rate.toInt()).isEqualTo(100)
    }
}