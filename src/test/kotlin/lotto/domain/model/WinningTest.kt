package lotto.domain.model

import lotto.Lotto
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WinningTest {
    lateinit var winning: Winning

    @BeforeEach
    fun `setUp`() {
        winning = Winning(listOf(1,2,3,4,5,6),8)
    }

    @Test
    fun `당첨 번호가 6개가 아닌 경우 예외가 발생 한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5), 6)
        }
    }

    @Test
    fun `당첨 번호가 중복이 있을 경우 예외가 발생 한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5, 5), 6)
        }
    }

    @Test
    fun `당첨 번호 또는 보너스 숫자가 1에서 45가 아닐 경우 예외가 발생 한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5, 46), 6)
            Winning(listOf(0,2,3,4,5,7),6)
            Winning(listOf(1,2,3,4,5,6),46)
            Winning(listOf(1,2,3,4,5,6),-1)
        }
    }


}