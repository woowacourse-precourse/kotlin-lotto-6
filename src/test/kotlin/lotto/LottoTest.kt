package lotto

import lotto.domain.Lotto
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

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 시작 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호가 끝 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또가 특정 숫자를 포함하고 있다면 true를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = true
        assertThat(expected).isEqualTo(lotto.hasNumber(1))
    }

    @Test
    fun `로또가 특정 숫자를 포함하고 있지 않으면 false를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = false
        assertThat(expected).isEqualTo(lotto.hasNumber(7))
    }

    @Test
    fun `로또는 오름차순으로 나열된 numbers 문자열을 반환한다`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        val expected = "[1, 2, 3, 4, 5, 6]"
        assertThat(expected).isEqualTo(lotto.toString())
    }
}
