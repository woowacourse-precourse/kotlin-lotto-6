package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.WinningLotto
import org.assertj.core.api.Assertions
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
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `lotto numbers 안에 parameter로 전달되는 숫자가 포함되어 있는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        Assertions.assertThat(lotto.contains(1)).isTrue()
        Assertions.assertThat(lotto.contains(10)).isFalse()
    }

    @Test
    fun `getNumbers()함수가 잘 출력되는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6).toString())
    }
    @Test
    fun `hasBonusNumber() 함수 검증`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).hasBonusNumber(winningLotto)).isFalse()
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 7)).hasBonusNumber(winningLotto)).isTrue()
    }

    @Test
    fun `compareWinningLotto() 함수 검증`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).compareWinningLotto(winningLotto.winningNumbers))
            .isEqualTo(6)
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 7)).compareWinningLotto(winningLotto.winningNumbers))
            .isEqualTo(5)
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 10, 11)).compareWinningLotto(winningLotto.winningNumbers))
            .isEqualTo(4)
    }
}
