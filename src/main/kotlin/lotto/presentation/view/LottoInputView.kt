package lotto.presentation.view

import camp.nextstep.edu.missionutils.Console

class LottoInputView {

    fun getPrice(): Int {
        val input = Console.readLine()
        val result = requireNotNull(input.toIntOrNull())
        require(result % 1000 == 0)
        return result
    }

    fun getWinningNumbers(): List<Int> {
        val input = Console.readLine()
        val winningNumbers = input.split(",").map { number ->
            requireNotNull(number.toIntOrNull())
        }
        require(winningNumbers.size == 6)
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        val input = Console.readLine()
        return requireNotNull(input.toIntOrNull())
    }

}