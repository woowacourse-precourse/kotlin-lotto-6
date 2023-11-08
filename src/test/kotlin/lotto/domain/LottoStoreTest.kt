package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStoreTest {
  private lateinit var myLottoStore: LottoStore

  @BeforeEach
  fun setUp() {
    myLottoStore = LottoStore()
  }

  @Test
  fun `sellIssuedLottos 메서드 테스트 - 구매 수량만큼의 로또를 발행해야 한다`() {
    val purchaseAmount = 7
    val issuedLottos = myLottoStore.sellIssuedLottos(purchaseAmount)

    assertThat(issuedLottos.size).isEqualTo(purchaseAmount)
  }
}