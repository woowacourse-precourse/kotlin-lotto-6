package lotto.util

import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoValidatorUtilTest {

    @DisplayName("중복되는 수 입력 검증")
    @ParameterizedTest
    @MethodSource("winningNumberSizeInvalidProvider")
    fun `checkWinningNumberSize - 당첨번호의 갯수가 유효하지 않으면 예외가 발생한다`(winningNumber: List<Int>) {
        // given
        val exception = assertThrows<java.lang.IllegalArgumentException> {
            LottoValidatorUtil.checkWinningNumberSize(winningNumber)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID
        // then
        Assertions.assertEquals(expectedExceptionMessage, exception.message)
    }

    @Test
    fun checkNumberInRange() {
    }

    @Test
    fun checkMoneyAvailable() {
    }

    @Test
    fun checkWinningNumberAvailable() {
    }

    @Test
    fun checkNumberOverlap() {
    }

    companion object {
        @JvmStatic
        fun winningNumberSizeInvalidProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1,2)),
                Arguments.of(listOf(1,2,3,9)),
                Arguments.of(listOf(1,2,3,4,5,6,7)),
                Arguments.of(listOf(1,2,3,4)),
            )
        }
    }
}