package lotto.domain

import lotto.constant.ErrorMessage

class BonusNumber(private val bonusNumber: Int) {

    fun validateBonusNumber(winningNumbers: WinningNumbers) {
        if (bonusNumber !in WINNING_NUMBER_START..WINNING_NUMBER_END) {
            throw IllegalStateException(ErrorMessage.NOT_NUMBER_RANGE_BONUS_NUMBER.message)
        }
        val numbers = winningNumbers.getWinningNumbers()
        if (numbers!!.contains(bonusNumber)) {
            throw IllegalStateException(ErrorMessage.NOT_DUPLICATED_BONUS_NUMBER.message)
        }

    }

    fun loadBonusNumber() = bonusNumber

    companion object {
        private const val WINNING_NUMBER_START = 1
        private const val WINNING_NUMBER_END = 45
    }
}