package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class IssueLottoTest {
    @Test
    fun `구입한 로또 수량이 3개다`() {
        val calculateAmount = IssueLotto(3000)
        val result = calculateAmount.calculate()
        assertThat(result).isEqualTo(3)
    }
}