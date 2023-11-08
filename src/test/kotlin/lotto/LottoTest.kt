package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


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

    @DisplayName("로또 번호 범위 예외처리")
    @ParameterizedTest
    @MethodSource("lottoInRangeProvider")
    fun `로또 번호가 1~45 범위 내에 있지 않으면 예외가 발생한다`(lottoNumbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun lottoInRangeProvider() : Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(1,2,3,4,5,46)),
                Arguments.of(listOf(1,99,3,9,2,4)),
                Arguments.of(listOf(1,2,3,0,6,7)),
                Arguments.of(listOf(-1,2,3,4,5,6)),
            )
    }
}
