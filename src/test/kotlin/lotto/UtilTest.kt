package lotto

import lotto.utils.convertWithDigitComma
import lotto.utils.convertWithRound
import lotto.utils.retryWhileNoException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class UtilTest {

    @ParameterizedTest
    @MethodSource("테스트데이터_천단위_쉼표")
    fun `숫자의 천 단위로 쉼표를 붙인다`(변경할_숫자: Int, 기댓값: String) {
        // given

        // when
        val 결과 = 변경할_숫자.convertWithDigitComma()

        // then
        Assertions.assertThat(결과).isEqualTo(기댓값)
    }

    @ParameterizedTest
    @MethodSource("테스트데이터_소수_첫째자리_반올림")
    fun `소수점 첫째자리까지 반올림한다`(변경할_소수: Double, 기댓값: String) {
        // given

        // when
        val 결과 = 변경할_소수.convertWithRound()

        // then
        Assertions.assertThat(결과).isEqualTo(기댓값)
    }

    @Test
    fun `예외가 발생하지 않을 때까지 반복한다`() {
        // given
        val 반복횟수 = 5
        var 증가값 = 0

        // when
        val 결과 = retryWhileNoException {
            if (증가값 < 반복횟수) {
                증가값++
                throw IllegalArgumentException()
            } else 증가값
        }

        // then
        Assertions.assertThat(결과).isEqualTo(반복횟수)
    }

    @Test
    fun `예외가 발생하지 않는 경우 반복하지 않고 바로 값을 반환한다`() {
        // given
        val 반환값 = 40

        // when
        val 결과 = retryWhileNoException { 반환값 }

        // then
        Assertions.assertThat(결과).isEqualTo(반환값)
    }

    companion object {
        @JvmStatic
        fun `테스트데이터_천단위_쉼표`() = listOf(
            Arguments.of(100, "100"),
            Arguments.of(4000, "4,000"),
            Arguments.of(15000000, "15,000,000"),
            Arguments.of(2000000000, "2,000,000,000"),
        )

        @JvmStatic
        fun `테스트데이터_소수_첫째자리_반올림`() = listOf(
            Arguments.of(1.35, "1.4"),
            Arguments.of(20.3333, "20.3"),
            Arguments.of(20, "20.0"),
            Arguments.of(1234.56789, "1234.6"),
            Arguments.of(100.1, "100.1")
        )
    }
}