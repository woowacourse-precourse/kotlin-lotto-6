package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoManagerTest {
    @Test
    fun managerTest() {
        val testManager = LottoManager()
        testManager.generateLotto()
        testManager.generateLotto()
        val testLotto = testManager.getLotto()
        Assertions.assertThat(testLotto.size).isEqualTo(2)
    }
}