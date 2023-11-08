package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class UnitTest {
    @Test
    fun `로또 검사기가 올바르게 동작하는지 확인`() {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val lotto1 = Lotto(listOf(2,3,4,5,6,7))
        val bonusNumber = 1

        val output = LottoInspector().checkLotto(lotto1,winningNumbers,bonusNumber)
        assertThat(output == LottoAward.SECOND.reward)
    }
}