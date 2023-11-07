package lotto

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

    @Test
    fun `6개의 당첨 번호와 일치한다`() {
        val luckyNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val matchCount = lotto.matchNumbers(luckyNumbers)

        assertThat(matchCount).isEqualTo(6)
    }
}
