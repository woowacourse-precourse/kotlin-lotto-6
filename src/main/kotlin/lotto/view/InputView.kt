package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.utils.ExceptionHandler

class InputView {
    private val outputView = OutputView()

    fun inputMoney(): Money {
        while (true) {
            try {
                val input = Console.readLine().trim()
                ExceptionHandler.isBlank(input)
                ExceptionHandler.isDigit(input)
                val money = Money(input.toInt())
                return money
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputWinningNumbersWithBonusNumber(): Pair<WinningLotto, LottoNumber> {
        while (true) {
            try {
                val winningLotto = inputWinningNumber()
                val bonusNumber = inputBonusNumber()
                ExceptionHandler.checkBonusNumberIsDuplicate(winningLotto, bonusNumber)
                return Pair(winningLotto, bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputWinningNumber(): WinningLotto {
        outputView.printAskWinningNumber()
        val input = Console.readLine()
        ExceptionHandler.winningNumbersIsDigit(input)
        val winningLotto = WinningLotto(input.split(",").map { LottoNumber(it.toInt()) })
        return winningLotto
    }

    private fun inputBonusNumber(): LottoNumber {
        outputView.printAskBonusNumber()
        val input = Console.readLine()
        ExceptionHandler.isDigit(input)
        val bonusNumber = LottoNumber(input.toInt())
        return bonusNumber
    }
}