package lotto

import camp.nextstep.edu.missionutils.Console

class WinningLotto {

    private var _winningNumbers: List<Int> = listOf()
    val winningNumbers: List<Int>
        get() = _winningNumbers

    private var _bonusNumber: Int = 0
    val bonusNumber: Int
        get() = _bonusNumber

    fun createWinningNumbers() {
        initializeWinningNumbers()
    }

    private fun initializeWinningNumbers() {
        _winningNumbers = readWinningNumbers()
    }

    fun createBonusNumber() {
        initializeBonusNumber()
    }

    private fun initializeBonusNumber() {
        _bonusNumber = readBonusNumber()
    }

    private fun readWinningNumbers(): List<Int> {
        var input: String
        do {
            println(InfoMessage.INPUT_WINNING_NUMBERS.message)
            input = Console.readLine().trim()
        } while (!Validator(input).isWinningNumbersValid())
        return input.split(",").map { it.toInt() }
    }

    private fun readBonusNumber(): Int {
        var input: String
        do {
            println(InfoMessage.INPUT_BONUS_NUMBER.message)
            input = Console.readLine()
        } while (!Validator(input).isBonusBallValid(winningNumbers))
        return input.toInt()
    }

}