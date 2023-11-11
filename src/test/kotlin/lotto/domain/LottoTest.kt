package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


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

    @ParameterizedTest
    @CsvSource(value = ["1 : true", "7 : false"], delimiter = ':')
    fun `로또가 특정 숫자를 포함하고 있다면 true, 아니면 false를 반환한다`(number: Int, expected: Boolean) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasNumber(number)).isEqualTo(expected)
    }

    @Test
    fun `로또는 오름차순으로 나열된 numbers 문자열을 반환한다`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        val expected = "[1, 2, 3, 4, 5, 6]"
        assertThat(expected).isEqualTo(lotto.toString())
    }
}
