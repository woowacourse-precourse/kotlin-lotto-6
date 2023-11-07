import lotto.domain.Lotto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1부터 45 사이가 아닌 경우 예외 발생`() {
        val invalidNumbers = listOf(0, 2, 3, 4, 5, 6) // 0은 유효 범위 밖
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(invalidNumbers)
        }
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.message)
    }
}
