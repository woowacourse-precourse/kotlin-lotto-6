package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


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
    fun `로또 번호에 1과 45 범위 외의 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 48))
        }
    }

    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    @ParameterizedTest
    fun `로또 번호와 일치하는 숫자가 있는지 확인할 수 있다`(number: Int) {
        val lottoTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoTicket.hasBonusNumber(number)).isTrue()
    }

    @Test
    fun `당첨 복권과 일치하는 숫자의 개수를 알 수 있다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoTicket = Lotto(listOf(1, 2, 3, 4, 5, 10))
        assertThat(lottoTicket.countMatchingNumbers(winningNumbers)).isEqualTo(5)
    }

}
