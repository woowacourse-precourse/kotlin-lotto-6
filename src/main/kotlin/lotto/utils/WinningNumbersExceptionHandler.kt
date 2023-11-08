package lotto.utils

import lotto.constants.ExceptionMessage.NOT_INTEGER_NUMBERS
import lotto.constants.ExceptionMessage.NOT_AS_MANY_AS_LOTTO_COUNT
import lotto.constants.ExceptionMessage.NOT_UNIQUE_NUMBERS
import lotto.constants.ExceptionMessage.OUT_OF_RANGE_NUMBERS
import lotto.constants.Lotto.LOTTO_COUNT
import lotto.constants.Lotto.LOTTO_END_NUMBER
import lotto.constants.Lotto.LOTTO_START_NUMBER

object WinningNumbersExceptionHandler {

  var winningNumbers = listOf<Int>()
  var bonusNumbers = listOf<Int>()

  fun validateWinningNumbers(separatedWinningNumbers: List<String>): List<Int> {
    validateCount(separatedWinningNumbers)
    val trimmedWinningNumbers = separatedWinningNumbers.map { it.trim() }
    winningNumbers = validateNumbersInteger(trimmedWinningNumbers)
    validateNumbersRange(winningNumbers)
    validateNumbersUnique(winningNumbers)

    return winningNumbers
  }

  private fun validateNumbersUnique(numbers: List<Int>) {
    if (numbers.size != numbers.toSet().size) {
      throw IllegalArgumentException(NOT_UNIQUE_NUMBERS)
    }
  }

  private fun validateNumbersRange(numbers: List<Int>) {
    if (
      !numbers.all{ number -> number in LOTTO_START_NUMBER..LOTTO_END_NUMBER }
      ) {
      throw IllegalArgumentException(OUT_OF_RANGE_NUMBERS)
    }
  }

  private fun validateNumbersInteger(trimmedNumbers: List<String>): List<Int> {
    val numbers = trimmedNumbers.map { item -> item.toIntOrNull() ?: -1 }

    if(-1 in numbers) {
      throw IllegalArgumentException(NOT_INTEGER_NUMBERS)
    }

    return numbers
  }

  private fun validateCount(separatedWinningNumbers: List<String>) {
    if (separatedWinningNumbers.size != LOTTO_COUNT) {
      throw IllegalArgumentException(NOT_AS_MANY_AS_LOTTO_COUNT)
    }
  }

  fun validateBonusNumber(inputBonusNumber: String): List<Int> {
    val trimmedBonusNumbers = listOf(inputBonusNumber.trim())
    bonusNumbers = validateNumbersInteger(trimmedBonusNumbers)
    validateNumbersRange(bonusNumbers)
    validateNumbersUnique(winningNumbers + bonusNumbers)

    return bonusNumbers
  }
}