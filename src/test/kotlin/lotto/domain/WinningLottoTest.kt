package lotto.domain

import lotto.domain.lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `보너스 번호는 1~45 사이의 숫자가 아니면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6, 7)), 47)
        }
    }

    @Test
    fun `보너스 번호는 당첨번호와 중복되면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6, 7)), 1)
        }
    }
}