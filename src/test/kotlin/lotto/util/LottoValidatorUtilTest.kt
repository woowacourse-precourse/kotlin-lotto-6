package lotto.util

import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
import lotto.constants.Error.EXCEPTION_MESSAGE_NOT_IN_RANGE
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID
import lotto.constants.LottoConstants.LOTTO_SIZE
import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream
import kotlin.IllegalArgumentException

internal class LottoValidatorUtilTest {

    @DisplayName("당첨번호 갯수 검증")
    @ParameterizedTest
    @MethodSource("winningNumberSizeInvalidProvider")
    fun `checkWinningNumberSize - 당첨번호의 갯수가 유효하지 않으면 예외가 발생한다`(winningNumber: List<Int>) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkWinningNumberSize(winningNumber)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID
        // then
        assertEquals(expectedExceptionMessage, exception.message)
    }

    @DisplayName("중복되는 수 입력 검증")
    @ParameterizedTest
    @MethodSource("winningNumberOverlappedProvider")
    fun `checkWinningNumberSize - 당첨번호에 중복되는 숫자가 존재하면 예외가 발생한다`(winningNumber: List<Int>) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkWinningNumberSize(winningNumber)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST
        // then
        assertEquals(expectedExceptionMessage, exception.message)
    }

    @DisplayName("로또 번호 범위 검증")
    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 323, 77])
    fun `checkNumberInRange - 로또 번호는 1 ~ 45 사이의 숫자여야한다`(number: Int) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkNumberInRange(number)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_NOT_IN_RANGE
        // then
        assertEquals(expectedExceptionMessage, exception.message)
    }

    @DisplayName("입력금액 1000으로 나눠지지 않을 때 예외처리하는지 검증")
    @ParameterizedTest
    @ValueSource(strings = ["1100", "2100", "3300", "4400"])
    fun `checkMoneyAvailable - 입력금액은 1000으로 나눠져야한다`(moneyString: String) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkMoneyAvailable(moneyString)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE
        // then
        assertEquals(expectedExceptionMessage, exception.message)
    }

    @DisplayName("입력금액에 숫자가 아닌 문자가 입력 불가 검증")
    @ParameterizedTest
    @ValueSource(strings = ["숫자", "문자", "로또", "bamin0422"])
    fun `checkMoneyAvailable - 입력금액은 숫자로만 입력되어야한다`(moneyString: String) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkMoneyAvailable(moneyString)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
        // then
        assertEquals(expectedExceptionMessage, exception.message)
    }

    @DisplayName("입력금액이 유효한 값인지 검증")
    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "3000", "4000"])
    fun `checkMoneyAvailable - 입력금액이 유효한 값인지 검증`(moneyString: String) {
        val money = LottoValidatorUtil.checkMoneyAvailable(moneyString)
        assertThat(money % 1000 == 0).isTrue
    }

    @DisplayName("당첨번호가 올바른 형식으로 입력되었는지 검증")
    @ParameterizedTest
    @ValueSource(strings = ["2,3,4,bamin0422,pobi,woni", "1,2,3,a,4,5", "1,2,3,4,5,y", "1,3,4,5,8,,"])
    fun `checkWinningNumberAvailable - 당첨번호가 올바른 형식으로 입력되었는가`(winningNumberString: String) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkWinningNumberAvailable(winningNumberString)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
        // then
        assertEquals(expectedExceptionMessage, exception.message)
    }



    @DisplayName("당첨번호가 올바른 형식으로 입력을 때")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6", "4,5,7,9,11,43", "23,27,3,41,15,12", "12,31,41,25,18,9"])
    fun `checkWinningNumberAvailable - 당첨번호가 올바른 형식으로 입력되었을 때`(winningNumberString: String) {
        // given
        val lotto = LottoValidatorUtil.checkWinningNumberAvailable(winningNumberString)
        // when
        val expectedLottoSize = LOTTO_SIZE
        // then
        assertEquals(lotto.getNumbers().size, expectedLottoSize)
    }

    @DisplayName("보너스 번호가 중복되는지 검증")
    @ParameterizedTest
    @MethodSource("winningNumberBonusNumberOverlappedProvider")
    fun `checkNumberOverlap - 보너스 넘버와 당첨번호의 중복 여부 확인 및 예외처리`(winningNumber: Lotto, number: Int) {
        // given
        val exception = assertThrows<IllegalArgumentException> {
            LottoValidatorUtil.checkNumberOverlap(winningNumber, number)
        }
        // when
        val expectedExceptionMessage = EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST
        // then
        assertEquals(expectedExceptionMessage, exception.message)
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

        @JvmStatic
        fun winningNumberOverlappedProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1,2,2,2,2,3)),
                Arguments.of(listOf(1,2,3,9,9,4)),
                Arguments.of(listOf(6,2,3,4,5,6)),
                Arguments.of(listOf(1,2,3,4,3,2)),
            )
        }

        @JvmStatic
        fun winningNumberBonusNumberOverlappedProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(listOf(1,2,3,4,5,6)), 1),
                Arguments.of(Lotto(listOf(1,22,31,19,23,41)), 41),
                Arguments.of(Lotto(listOf(2,4,3,9,11,6)), 9),
                Arguments.of(Lotto(listOf(1,2,3,4,7,9)), 2),
            )
        }
    }
}