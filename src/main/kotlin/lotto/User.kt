package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    var lottoProgramError = LottoProgramError()

    fun inputMoney():Int {
        val money = Console.readLine()
        lottoProgramError.checkIsNumber(money)
        lottoProgramError.checkInputMoneyDivided1000Won(money.toInt())
        return money.toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        val numbers = Console.readLine()
        val winningNumbers = separateCommas(numbers)
        lottoProgramError.checkNumberCountIsSix(winningNumbers)
        lottoProgramError.checkNumberIsRandom(winningNumbers)
        lottoProgramError.checkNumberRange(winningNumbers)
        return winningNumbers
    }

    fun inputBonusNumber(): Int {
        val bonusNumber = Console.readLine().toInt()
        lottoProgramError.checkBonusNumberRange(bonusNumber)
        return bonusNumber
    }

    fun separateCommas(numbers: String): List<Int> {
        var winningNumbers:MutableList<Int> = mutableListOf()

        numbers.split(",").toList().forEach {
            winningNumbers.add(it.toInt())
        }
        return winningNumbers
    }
}