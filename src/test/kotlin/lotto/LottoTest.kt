package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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
    fun `당첨 번호와 비교하여 갯수를 반환한다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumber = Lotto(listOf(1,2,3,4,13,10))
        val result = lotto.compareLottoNumber(winningNumber)
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `보너스 숫자와 비교 후 존재하면 true, 없다면 false를 반환한다 `() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val bonus = 5
        val result = lotto.compareBonusNumber(bonus)
        assertThat(result).isEqualTo(true)
    }
}
