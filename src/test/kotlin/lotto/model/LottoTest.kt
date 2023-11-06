package lotto.model

import org.assertj.core.api.Assertions.assertThat
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
    fun `로또 번호에 1 ~ 45 사이가 아닌 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 100))
        }
    }

    @Test
    fun `로또 번호와 당첨 번호를 비교하면 3개가 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.compareLotto(listOf(1, 2, 3, 14, 15, 16), 45)).isEqualTo(3)
    }

    @Test
    fun `로또 번호와 당첨 번호를 비교하면 4개가 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.compareLotto(listOf(1, 2, 3, 4, 15, 16), 45)).isEqualTo(4)
    }

    @Test
    fun `로또 번호와 당첨 번호를 비교하면 5개가 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.compareLotto(listOf(1, 2, 3, 4, 5, 16), 45)).isEqualTo(5)
    }

    @Test
    fun `로또 번호와 당첨 번호를 비교하면 5개와 보너스 번호가 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.compareLotto(listOf(1, 2, 3, 4, 5, 16), 6)).isEqualTo(50)
    }

    @Test
    fun `로또 번호와 당첨 번호를 비교하면 6개가 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.compareLotto(listOf(1, 2, 3, 4, 5, 6), 45)).isEqualTo(6)
    }
}
