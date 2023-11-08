package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoSellerTest {

    @Test
    fun `돈이 아닌 값을 입력했을 때 예외 발생`() {
        val money = "돈이 아닌 값"
        val lottoSeller = LottoSeller()
        assertThrows<IllegalArgumentException> {
            lottoSeller.checkLottoTicketCount(money)
        }
    }
    @Test
    fun `1000원 단위의 돈을 입력했는지`() {
        val money = "12"
        val lottoSeller = LottoSeller()
        assertThrows<IllegalArgumentException> {
            lottoSeller.checkLottoTicketCount(money)
        }
    }
}

