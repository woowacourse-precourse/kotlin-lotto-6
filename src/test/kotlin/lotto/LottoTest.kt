package lotto

import lotto.data.LottoWinnerInfo
import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {

    companion object {
        private lateinit var lotto: Lotto

        val numbers = listOf(1, 2, 3, 4, 5, 6)

        @BeforeAll
        @JvmStatic
        fun setUp() {
            lotto = Lotto(numbers)
        }
    }

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
    fun `로또 번호에 중복된 숫자가 하나일 때 `() {
        val received = lotto.matchingLotto(
            winningNumbers = listOf(1, 7, 8, 9, 10, 11),
            bonusNumber = 12
        )
        Assertions.assertThat(received).isEqualTo(LottoWinnerInfo.MatchUnderThree)
    }
}
