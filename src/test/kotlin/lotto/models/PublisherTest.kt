package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PublisherTest {

    @Test
    fun `구입 금액만큼 로또를 발행한다`() {
        val publisher = Publisher()
        val purchase = Purchase(5000)
        val expectedPublishedLottoCount = 5

        val actualPublishedLottoCount = publisher.publishLottos(purchase).size

        assertThat(actualPublishedLottoCount).isEqualTo(expectedPublishedLottoCount)
    }
}