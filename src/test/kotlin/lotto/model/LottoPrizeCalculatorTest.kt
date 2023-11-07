package lotto.model

import lotto.model.seller.Ticket
import lotto.model.seller.toMoney
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizeCalculatorTest {
    @Test
    fun `로또 5개를 구매하여 5등에 당첨되었을 때, 수익률이 100%이다`() {
        val ticket = Ticket(5000.toMoney())
        ticket.record(Lotto.of(1, 2, 3, 4, 5, 6))

        val calculator = LottoPrizeCalculator(Lotto.of(1, 2, 3, 10, 11, 12), Ball(7))
        val result = calculator.issueLottoResultReceipt(ticket)

        assertThat(result.rate.toInt()).isEqualTo(100)
    }
}