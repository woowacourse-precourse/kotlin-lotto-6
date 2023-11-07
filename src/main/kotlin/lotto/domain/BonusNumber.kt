package lotto.domain

import lotto.constant.ErrorMessage

class BonusNumber(private val bonusNumber: Int) {

    init {
        require(bonusNumber in BONUS_NUMBER_START..BONUS_NUMBER_END) { ErrorMessage.NOT_NUMBER_RANGE_BONUS_NUMBER.message }
    }

    fun validateBonusNumber(winningNumbers: WinningNumbers) {
        val numbers = winningNumbers.getWinningNumbers()
        require(!numbers!!.contains(bonusNumber)) { ErrorMessage.NOT_DUPLICATED_BONUS_NUMBER.message }
    }

    fun loadBonusNumber() = bonusNumber

    companion object {
        private const val BONUS_NUMBER_START = 1
        private const val BONUS_NUMBER_END = 45
    }
}