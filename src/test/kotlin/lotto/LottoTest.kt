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
    fun `로또 번호는 오름차순으로 정렬되어 있다`(){
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(6,5,4,3,2,1))
        }
    }

    @Test
    fun `로또를 출력할 때는 특정 형식을 따른다`(){
        assert(Lotto(listOf(1,2,3,4,5,6)).toString().equals("[1, 2, 3, 4, 5, 6]"))
    }

    @Test
    fun `당첨 로또 번호가 주어질 때 올바른 등수를 표시한다`(){
        assert(Lotto(listOf(1,2,3,4,5,6)).getRanks(Lotto(listOf(1,2,3,4,5,6)), 7) == 1)
    }

    // 아래에 추가 테스트 작성 가능
}
