package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.utils.ExceptionHandler

class InputView {

    fun inputMoney(): Int {
        while (true) {
            try {
                val money = Console.readLine().trim()
                ExceptionHandler.isBlank(money)
                ExceptionHandler.isDigit(money)
                return money.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputWinningNumbers(): WinningLotto {
        while (true) {
            try {
                val winningNumbers = Console.readLine()
                ExceptionHandler.winningNumbersIsDigit(winningNumbers)
                val winningLotto = WinningLotto(winningNumbers.split(",").map { LottoNumber(it.toInt()) })
                return winningLotto
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            try {
                val number = Console.readLine()
                ExceptionHandler.isDigit(number)
                return number.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}