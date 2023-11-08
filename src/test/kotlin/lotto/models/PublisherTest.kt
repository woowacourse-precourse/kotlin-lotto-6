package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PublisherTest {

    @Test
    fun `구입하려는 로또 개수만큼 로또를 발행한다`() {
        val publishingLottoCount = 5
        val expectedPublishedLottoCount = 5

        val publisher = Publisher(publishingLottoCount)
        val actualPublishedLottoCount = publisher.publishLottos().size

        assertThat(actualPublishedLottoCount).isEqualTo(expectedPublishedLottoCount)
    }
}