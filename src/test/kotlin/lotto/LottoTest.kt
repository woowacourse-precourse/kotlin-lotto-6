package lotto

import lotto.domain.model.BonusNumber
import lotto.domain.model.Lotto
import lotto.domain.model.Result
import lotto.domain.model.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
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

    // 아래에 추가 테스트 작성 가능
    @ParameterizedTest
    @MethodSource("provideNumbersSizeIsSmallerThanNumberOfLottoNumbers")
    @DisplayName("Lotto 생성시 숫자가 ${Lotto.NUMBER_OF_LOTTO_NUMBERS}개보다 적을 경우 예외 발생")
    fun createLotto_numbersSizeIsSmallerThanNumberOfLottoNumbers_throwIllegalArgumentException(numbers: List<Int>) {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(numbers) } // when
            .withMessage(Lotto.MISMATCH_NUMBER_OF_LOTTO_NUMBERS_MESSAGE) // then
    }

    @Test
    @DisplayName("Lotto 생성시 ${Lotto.MIN_NUMBER}~${Lotto.MAX_NUMBER} 사이의 숫자가 아닌 것이 있으면 예외 발생")
    fun createLotto_numbersOutOfRange_throwIllegalArgumentException() {
        // given
        val numbersOutOfRange = listOf(1, 2, 3, 4, 5, 46)

        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(numbersOutOfRange) } // when
            .withMessage(Lotto.NUMBERS_NOT_IN_VALID_RANGE) // then
    }

    @ParameterizedTest
    @MethodSource("provideNumbersNotInAscendingOrder")
    @DisplayName("Lotto 생성시 숫자가 오름차순이 아닌 경우 예외 발생")
    fun createLotto_numbersNotInAscendingOrder_throwIllegalArgumentException(numbers: List<Int>) {
        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(numbers) } // when
            .withMessage(Lotto.NUMBERS_NOT_IN_ASCENDING_ORDER) // then
    }

    @ParameterizedTest
    @MethodSource("winningNumbersAndBonusNumberAndResult")
    @DisplayName("Lotto와 당첨 번호, 보너스 번호가 주어질 경우 결과를 올바르게 계산하는지")
    fun calculateResult_winningNumbersAndBonusNumberAreGiven_calculateResultCorrectly(
        winningNumbers: List<Int>,
        bonusNumber: Int,
        expected: Result
    ) {
        // given
        val lotto = Lotto(numbers = listOf(1, 2, 3, 4, 5, 6))

        // when
        val result = lotto.calculateResult(
            winningNumbers = WinningNumbers(winningNumbers),
            bonusNumber = BonusNumber(bonusNumber)
        )

        // then
        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun provideNumbersSizeIsSmallerThanNumberOfLottoNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1)),
            Arguments.of(listOf(1, 2)),
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
        )

        @JvmStatic
        private fun provideNumbersNotInAscendingOrder(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 6, 5)),
            Arguments.of(listOf(2, 1, 3, 4, 6, 5)),
            Arguments.of(listOf(4, 5, 6, 1, 2, 3)),
            Arguments.of(listOf(1, 2, 4, 3, 5, 6)),
            Arguments.of(listOf(6, 5, 4, 3, 2, 1)),
        )

        @JvmStatic
        private fun winningNumbersAndBonusNumberAndResult(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 45, Result.FIRST_PLACE),
            Arguments.of(listOf(1, 2, 3, 4, 5, 10), 6, Result.SECOND_PLACE),
            Arguments.of(listOf(1, 2, 3, 4, 5, 10), 45, Result.THIRD_PLACE),
            Arguments.of(listOf(1, 2, 3, 4, 10, 11), 45, Result.FOURTH_PLACE),
            Arguments.of(listOf(1, 2, 3, 10, 11, 12), 45, Result.FIFTH_PLACE),
            Arguments.of(listOf(1, 2, 10, 11, 12, 13), 45, Result.NOTHING),
            Arguments.of(listOf(1, 10, 11, 12, 13, 14), 45, Result.NOTHING),
            Arguments.of(listOf(10, 11, 12, 13, 14, 15), 45, Result.NOTHING),
        )
    }
}
