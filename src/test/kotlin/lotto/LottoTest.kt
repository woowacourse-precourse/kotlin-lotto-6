package lotto

import lotto.Model.Lotto
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
    fun `로또 번호의 개수가 6개 이하면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,2))
        }
    }

    fun `공백을 입력하는 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf())
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
    fun `로또 번호의 범위가 1~45 사이가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,2,3,4,78,3))
        }
    }




    // 아래에 추가 테스트 작성 가능
}
