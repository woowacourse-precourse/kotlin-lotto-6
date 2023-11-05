package lotto

import lotto.model.Lotto
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
    fun `로또 번호가 범위(1 -45)를 벗어나면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,50,20,32,7,30))
        }
    }
    @Test
    fun `로또 번호가 양수가 아닐시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(4,7,-6,7,10,32))
        }
    }
}
