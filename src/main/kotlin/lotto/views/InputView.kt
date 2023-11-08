package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constant.Companion.START_INDEX
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_CHARACTER

object InputView {
    fun inputMoney(): String {
        return Console.readLine()
    }

    fun inputWinningNumber(): MutableList<Int> {
        val winningNumbers = mutableListOf<Int>()
        val input: List<String> = Console.readLine().trim().split(',')
        for (index in START_INDEX until input.size) {
            if (!input[index].all { Character.isDigit(it) }) {
                OutputView.printExceptionMessage(EXCEPTION_INVALID_CHARACTER)
                throw IllegalArgumentException(EXCEPTION_INVALID_CHARACTER)
            }
            winningNumbers.add(input[index].toInt())
        }
        return winningNumbers
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }
}