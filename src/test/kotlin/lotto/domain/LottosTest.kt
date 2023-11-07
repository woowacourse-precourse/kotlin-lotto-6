package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.Lottos
import lotto.domain.model.Purchase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottosTest {

    @Test
    fun `Lottos는 생성된 Lotto로 만들어진다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertDoesNotThrow { Lottos(listOf(lotto)) }
    }

    @Test
    fun `로또 구매 금액을 입력했을 시 제대로 로또가 생성되는지 확인`() {
        val purchase = Purchase(10000)
        val makeLottos = LottoGenerator().make(purchase)
        Assertions.assertThat(makeLottos.lottos.size).isEqualTo(10)
    }
}
