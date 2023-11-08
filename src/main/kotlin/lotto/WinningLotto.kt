package lotto

import camp.nextstep.edu.missionutils.Console

class WinningLotto {

    private var _winningNumbers: List<Int> = listOf()
    val winningNumbers: List<Int>
        get() = _winningNumbers

    private var _bonusNumber: Int = 0
    val bonusNumber: Int
        get() = _bonusNumber

    fun initializeWinningNumbers() {
        _winningNumbers = readWinningNumbers()
    }

    fun initializeBonusNumber() {
        _bonusNumber = readBonusNumber()
    }

    private fun readWinningNumbers(): List<Int> {
        var input: String
        do {
            println(InfoMessage.INPUT_WINNING_NUMBERS.message)
            input = Console.readLine().trim()
        } while (!WinningNumbersValidator(input).isValid())
        return input.split(",").map { it.toInt() }
    }

    private fun readBonusNumber(): Int {
        var input: String
        do {
            println(InfoMessage.INPUT_BONUS_NUMBER.message)
            input = Console.readLine()
        } while (!BonusNumberValidator(input).isValid(winningNumbers))
        return input.toInt()
    }

}