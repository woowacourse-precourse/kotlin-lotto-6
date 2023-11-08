package lotto

import lotto.model.Lotto
import lotto.model.WinningLotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    @ValueSource(ints = [-1, 0, 46])
    @ParameterizedTest
    fun `보너스 번호는 1~45 사이가 아니면 예외가 발생한다`(int: Int) {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1,2,3,4,5,6)), int)
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1,2,3,4,5,6)), 1)
        }
    }
}