package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


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

    @ParameterizedTest
    @MethodSource("1~45 이외의 숫자")
    fun `로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다`(exceptionNumbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(exceptionNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun `1~45 이외의 숫자`(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 0)),
                Arguments.of(listOf(1, 2, 3, 4, 5, -1))
            )
        }
    }
}
