package lotto.model

import lotto.model.seller.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `3개의 로또를 발행했을 때, 발행한 티켓의 로또 개수가 3개이다`() {
        val lottoGenerator = LottoGenerator.createWithRandomGenerator()
        val ticket = lottoGenerator.createLottos(3)
        assertThat(ticket.lottoCount).isEqualTo(3)
    }
}