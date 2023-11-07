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
        println(INPUT_WINNING_NUMBERS)
        initializeWinningNumbers()
    }

    private fun initializeWinningNumbers() {
        _winningNumbers = readWinningNumbers()
    }

    fun createBonusNumber() {
        println(INPUT_BONUS_NUMBER)
        initializeBonusNumber()
    }

    private fun initializeBonusNumber() {
        _bonusNumber = readBonusNumber()
    }

    private fun readWinningNumbers(): List<Int> {
        var input: String
        do {
            input = Console.readLine().trim()
        } while (!Validator(input).isWinningNumbersValid())
        return Console.readLine().trim().split(",").map { it.toInt() }
    }

    private fun readBonusNumber(): Int = Console.readLine().toInt()

    companion object {
        const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }

}