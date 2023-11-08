package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.GuideMessage.ENTER_BONUS_NUMBER
import lotto.constants.GuideMessage.ENTER_WINNING_NUMBERS
import lotto.utils.WinningNumbersExceptionHandler
import lotto.utils.WinningNumbersSeparator

object WinningLottoView {
  fun printWinningNumbersInputMessage() {
    println(ENTER_WINNING_NUMBERS)
  }

  fun inputWinningNumbers(): List<Int> {
    val inputWinningNumbers: String = Console.readLine()
    val separatedWinningNumbers = WinningNumbersSeparator.separateWinningNumbers(inputWinningNumbers)

    val winningNumbers: List<Int> = try {
      WinningNumbersExceptionHandler.validateWinningNumbers(separatedWinningNumbers)
    } catch (e: IllegalArgumentException) {
      ExceptionView.printExceptionMessage(e)
      inputWinningNumbers()
    }

    return winningNumbers
  }

  fun printBonusNumberInputMessage() {
    println(ENTER_BONUS_NUMBER)
  }

  fun inputBonusNumber(): List<Int> {
    val inputBonusNumber: String = Console.readLine()

    val bonusNumber: List<Int> = try {
      WinningNumbersExceptionHandler.validateBonusNumber(inputBonusNumber)
    } catch (e: IllegalArgumentException) {
      ExceptionView.printExceptionMessage(e)
      inputBonusNumber()
    }

    return bonusNumber
  }
}