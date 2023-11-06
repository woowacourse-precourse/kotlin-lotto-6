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

    // TODO 예외처리
    private fun readWinningNumbers(): List<Int> {
        return Console.readLine().trim().split(",").map { it.toInt() }
    }

    private fun readBonusNumber(): Int {
        return Console.readLine().toInt()
    }

}