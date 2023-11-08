package lotto

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호들의 개수가 6이 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45를 벗어나는 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `번호들이 중복되지 않으면 참을 반환한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        assertTrue(numbers.isUnique())
    }

    @Test
    fun `번호들이 중복되면 거짓을 반환한다`() {
        val numbers = listOf(1, 2, 2, 4, 5, 6)
        assertFalse(numbers.isUnique())
    }

    @Test
    fun `번호들이 모두 1~45사이의 숫자이면 참을 반환한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        assertTrue(numbers.isAllLottoNumberInRange())
    }

    @Test
    fun `번호들이 모두 1~45사이의 숫자가 아니면 거짓을 반환한다`() {
        val numbers = listOf(1, 2, 50, 4, 5, 6)
        assertFalse(numbers.isAllLottoNumberInRange())
    }

    @Test
    fun `번호가 1~45사이의 숫자이면 참을 반환한다`() {
        val number = 10
        assertTrue(number.isLottoNumberInRange())
    }

    @Test
    fun `번호가 1~45사이의 숫자가 아니면 거짓을 반환한다`() {
        val number = 0
        assertFalse(number.isLottoNumberInRange())
    }
}
