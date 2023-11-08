package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputMoney() {
        val money = Console.readLine()
    }

    fun inputWinningNumbers(): List<String> {
        val numbers = Console.readLine()
        val winningNumbers = separateCommas(numbers)
        return winningNumbers
    }

    fun inputBonusNumber() {
        val bonusNumber = Console.readLine()
    }

    fun separateCommas(winningNumbers: String): List<String> {
        val winningNumbers: List<String> = winningNumbers.split(",").toList()
        return winningNumbers
    }
}