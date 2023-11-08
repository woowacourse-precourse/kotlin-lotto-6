package lotto.model

import lotto.utils.Constants.INITIALIZE_NUMBER

class Winning(
    private var winningNumbers: List<Int> = listOf(),
    private var bonusNumber: Int = INITIALIZE_NUMBER
) {
    fun setWinningNumbers(newWinningNumber: List<Int>) {
        this.winningNumbers = newWinningNumber
    }

    fun setBonusNumber(newBonusNumber: Int) {
        this.bonusNumber = newBonusNumber
    }

    fun getWinningNumbers(): List<Int> = winningNumbers.toList()

    fun getBonusNumber(): Int = bonusNumber
}