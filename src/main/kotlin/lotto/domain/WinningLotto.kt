package lotto.domain


import lotto.util.Exception

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    init {
        validate()
    }

    fun getWinningNumbers() = winningNumbers

    fun getBonusNumber() = bonusNumber

    private fun validate() {
        Exception.validateWinningNumber(winningNumbers)
        Exception.validateBonusNumber(bonusNumber)
        Exception.validateWinningLotto(winningNumbers, bonusNumber)
    }
}