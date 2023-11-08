package lotto.utils

object WinningNumbersSeparator {
  fun separateWinningNumbers(inputWinningNumbers: String): List<String> {

    return inputWinningNumbers.split(',')
  }
}