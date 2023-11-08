package lotto.model.seller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSellerTest {

    @Test
    fun `돈을 3000원 냈을 때, 로또를 3개 발행한다`() {
        val seller = LottoSeller()
        val ticket = seller.issueLottoTicket(moneyInput = "3000")
        assertThat(ticket.lottoCount).isEqualTo(3)
    }
}