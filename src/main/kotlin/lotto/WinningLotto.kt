package lotto

import camp.nextstep.edu.missionutils.Console

class WinningLotto {

    private var winningNumbers: Lotto? = null
    private var bonusNumber: Int = 0

    fun initializeWinningNumbers() {
        winningNumbers = readWinningNumbers()
    }

    fun initializeBonusNumber() {
        bonusNumber = readBonusNumber()
    }


    // TODO 예외처리
    private fun readWinningNumbers(): Lotto {
        return Lotto(Console.readLine().trim().split(",").map { it.toInt() })
    }

    private fun readBonusNumber(): Int {
        return Console.readLine().toInt()
    }

}