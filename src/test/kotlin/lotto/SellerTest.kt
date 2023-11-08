package lotto

import lotto.model.Seller
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class SellerTest {
    @Test
    fun `구입한 금액만큼 로또 개수를 반환하는지 확인`() {
        val seller = Seller().sellLotto(8000)
        assertThat(seller.size).isEqualTo(8)
    }
}