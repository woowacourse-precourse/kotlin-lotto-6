package lotto

import lotto.domain.WinningLotto
import lotto.domain.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `당첨 번호, 보너스 번호가 겹치지 않을 경우`() {
        assertDoesNotThrow {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        }
    }

    @Test
    fun `당첨 번호, 보너스 번호가 겹칠 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 6)
        }
    }

    @Test
    fun `당첨 번호, 보너스 번호가 숫자 영역을 벗어날 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 46)), 6)
        }
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 46)
        }
    }
}
