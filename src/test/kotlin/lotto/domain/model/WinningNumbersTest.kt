package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    @DisplayName("WinningNumbers 생성시 올바른 숫자들을 입력할 경우 성공적으로 생성됨")
    fun createWinningNumbers_validNumbers_createdSuccessfully(numbers: List<Int>) {
        // when
        val winningNumbers = WinningNumbers(numbers = numbers)

        // then
        assertThat(winningNumbers.numbers).isEqualTo(numbers)
    }

    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    @DisplayName("WinningNumbers 생성시 올바른 숫자들을 입력할 경우 numbers의 크기는 항상 ${Lotto.NUMBER_OF_LOTTO_NUMBERS}")
    fun createWinningNumbers_validNumbers_sizeIsEqualToNumberOfLottoNumbers(numbers: List<Int>) {
        // when
        val winningNumbers = WinningNumbers(numbers = numbers)

        // then
        assertThat(winningNumbers.numbers.size).isEqualTo(Lotto.NUMBER_OF_LOTTO_NUMBERS)
    }

    @Test
    @DisplayName("WinningNumbers 생성시 ${Lotto.MIN_NUMBER}~${Lotto.MAX_NUMBER} 사이의 숫자가 아닌 것이 있으면 예외 발생")
    fun createWinningNumbers_numbersOutOfRange_throwIllegalArgumentException() {
        // given
        val outOfRangeNumbers = listOf(1, 2, 3, 4, 5, 46)

        assertThatIllegalArgumentException()
            .isThrownBy { WinningNumbers(outOfRangeNumbers) } // when
            .withMessage(Lotto.NUMBERS_NOT_IN_VALID_RANGE) // then
    }

    @Test
    @DisplayName("Winning Numbers 생성시 중복된 숫자가 존재할 경우 예외 발생")
    fun createWinningNumbers_duplicatedNumbersExist_throwIllegalArgumentException() {
        // given
        val duplicatedNumbers = listOf(1, 2, 3, 4, 5, 1)

        assertThatIllegalArgumentException()
            .isThrownBy { WinningNumbers(duplicatedNumbers) } // when
            .withMessage(WinningNumbers.DUPLICATED_NUMBER_EXIST_EXCEPTION_MESSAGE) // then

    }

    @ParameterizedTest
    @MethodSource("provideNumbersSizeIsNotEqualToNumberOfLottoNumbers")
    @DisplayName("Winning Numbers 생성시 숫자가 ${Lotto.NUMBER_OF_LOTTO_NUMBERS}개가 아닌 경우 예외 발생")
    fun createWinningNumbers_numbersSizeIsNotEqualToNumberOfLottoNumbers_throwIllegalArgumentException(numbers: List<Int>) {
        assertThatIllegalArgumentException()
            .isThrownBy { WinningNumbers(numbers) } // when
            .withMessage(WinningNumbers.MISMATCH_NUMBER_OF_WINNING_NUMBERS) // then
    }


    companion object {
        @JvmStatic
        private fun provideValidNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(listOf(10, 34, 23, 12, 11, 9)),
        )

        @JvmStatic
        private fun provideNumbersSizeIsNotEqualToNumberOfLottoNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1)),
            Arguments.of(listOf(1, 2)),
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
        )
    }
}