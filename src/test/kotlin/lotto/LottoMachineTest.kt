package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `로또 입력 금액이 1000원 단위가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine(11800)
        }
    }

    @Test
    fun `로또 입력 금액이 1000원 보다 적은 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine(800)
        }
    }
}