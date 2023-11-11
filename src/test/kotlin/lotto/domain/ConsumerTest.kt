package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ConsumerTest {
    @Test
    fun consumerTest() {
        val testConsumer = Consumer()
        testConsumer.purchaseLotto(3)
        val testManager = testConsumer.getManager()
        val testLotto = testManager.getLotto()
        Assertions.assertThat(testLotto.size).isEqualTo(3)
    }
}