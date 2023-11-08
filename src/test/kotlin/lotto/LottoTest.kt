package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(mutableListOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(mutableListOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1 ~ 45 사이에 있지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(mutableListOf(1, 2, 3, 4, 50, 6)) // 50은 1 ~ 45 범위 밖의 숫자
        }
    }
}
