package lotto

import domain.lotto.Lotto
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

    @Test
    fun `로또 번호가 1부터 45 사이의 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 6, 35, 40, 50))
        }
    }

    @Test
    fun `로또 번호가 오름차순이 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 4, 40, 37, 20, 5))
        }
    }
}
