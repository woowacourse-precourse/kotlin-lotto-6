package lotto.domain

import lotto.domain.model.Purchase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {

    @Test
    fun `구매 금액을 잘못 입력했을 시 에러 처리`() {
        assertThrows<IllegalArgumentException> {
            Purchase(0)
        }
    }

    @Test
    fun `구매 금액이 1,000원으로 나누어 떨어지지 않는 경우 에러 처리`() {
        assertThrows<IllegalArgumentException> {
            Purchase(1234)
        }
    }

    @Test
    fun `구매 금액을 입력했을 때 로또 구입 개수가 정확히 계산되는지 확인`() {
        Assertions.assertThat(Purchase(10000).getLottoCount()).isEqualTo(10)
    }
}
