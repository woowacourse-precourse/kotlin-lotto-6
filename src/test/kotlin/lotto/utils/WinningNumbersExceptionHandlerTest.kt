package lotto.utils

import lotto.constants.ExceptionMessage.NOT_AS_MANY_AS_LOTTO_COUNT
import lotto.constants.ExceptionMessage.NOT_INTEGER_NUMBERS
import lotto.constants.ExceptionMessage.NOT_UNIQUE_NUMBERS
import lotto.constants.ExceptionMessage.OUT_OF_RANGE_NUMBERS
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningNumbersExceptionHandlerTest {
  @DisplayName("validateWinningNumbers 메서드 테스트 - 정상적인 입력")
  @ParameterizedTest
  @MethodSource("goodWinningNumbersTest")
  fun goodWinningNumbersTest(separatedWinningNumbers: List<String>, expected: List<Int>) {
    val actual = WinningNumbersExceptionHandler.validateWinningNumbers(separatedWinningNumbers)

    Assertions.assertThat(actual).isEqualTo(expected)
  }

  @DisplayName("validateWinningNumbers 메서드 테스트 - 비정상적인 입력")
  @ParameterizedTest
  @MethodSource("badWinningNumbersTest")
  fun badWinningNumbersTest(separatedWinningNumbers: List<String>, message: String) {
    val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException>(message) {
      WinningNumbersExceptionHandler.validateWinningNumbers(separatedWinningNumbers)
    }
    Assertions.assertThat(message).isEqualTo(exception.message)
  }

  @DisplayName("validateBonusNumber 메서드 테스트 - 정상적인 입력")
  @ParameterizedTest
  @MethodSource("goodBonusNumberTest")
  fun goodBonusNumberTest(inputBonusNumber: String, expected: List<Int>) {
    val actual = WinningNumbersExceptionHandler.validateBonusNumber(inputBonusNumber)

    Assertions.assertThat(actual).isEqualTo(expected)
  }

  @DisplayName("validateBonusNumber 메서드 테스트 - 비정상적인 입력")
  @ParameterizedTest
  @MethodSource("badBonusNumberTest")
  fun badBonusNumberTest(inputBonusNumber: String, message: String) {
    WinningNumbersExceptionHandler.winningNumbers = listOf(2, 3, 4, 5, 6, 7)

    val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException>(message) {
      WinningNumbersExceptionHandler.validateBonusNumber(inputBonusNumber)
    }
    Assertions.assertThat(message).isEqualTo(exception.message)
  }

  companion object {
    @JvmStatic
    fun goodWinningNumbersTest() = listOf(
      Arguments.of(listOf("1", "2", "3", "4", "5", "6"), listOf(1, 2, 3, 4, 5, 6)),
      Arguments.of(listOf("  1 ", " 2", "3   ", "4", "5", "6"), listOf(1, 2, 3, 4, 5, 6)),
      Arguments.of(listOf("1", "2", "3", "4", "5", "45"), listOf(1, 2, 3, 4, 5, 45)),
    )

    @JvmStatic
    fun badWinningNumbersTest() = listOf(
      Arguments.of(listOf("1", "2", "3", "4", "5"), NOT_AS_MANY_AS_LOTTO_COUNT),
      Arguments.of(listOf("1", "2", "3", "4", "5", "6", "7"), NOT_AS_MANY_AS_LOTTO_COUNT),
      Arguments.of(listOf("1.3", "2", "3", "4", "5", "6"), NOT_INTEGER_NUMBERS),
      Arguments.of(listOf("1", "two", "3", "4", "5", "6"), NOT_INTEGER_NUMBERS),
      Arguments.of(listOf("", "2", "", "4", "5", "6"), NOT_INTEGER_NUMBERS),
      Arguments.of(listOf("1", "46", "200", "4", "5", "6"), OUT_OF_RANGE_NUMBERS),
      Arguments.of(listOf("1", "44", "-20", "4", "5", "6"), OUT_OF_RANGE_NUMBERS),
      Arguments.of(listOf("1", "2", "2", "3", "4", "5"), NOT_UNIQUE_NUMBERS),


    )

    @JvmStatic
    fun goodBonusNumberTest() = listOf(
      Arguments.of("8", listOf(8)),
      Arguments.of("  8 ", listOf(8)),
      Arguments.of("  45 ", listOf(45)),
      Arguments.of("1 ", listOf(1)),
    )

    @JvmStatic
    fun badBonusNumberTest() = listOf(
      Arguments.of("7.2", NOT_INTEGER_NUMBERS),
      Arguments.of("seven", NOT_INTEGER_NUMBERS),
      Arguments.of("", NOT_INTEGER_NUMBERS),
      Arguments.of("7, 8, 9", NOT_INTEGER_NUMBERS),
      Arguments.of("46", OUT_OF_RANGE_NUMBERS),
      Arguments.of("-5", OUT_OF_RANGE_NUMBERS),
      Arguments.of("0", OUT_OF_RANGE_NUMBERS),
      Arguments.of("4", NOT_UNIQUE_NUMBERS),
    )
  }
}