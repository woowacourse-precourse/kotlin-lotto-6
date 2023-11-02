package lotto.domain

import lotto.constant.ErrorMessage

class BonusNumber(private val bonusNumber: Int) {

    fun validateBonusNumber(winningNumbers: WinningNumbers) {
        if (bonusNumber !in 1..45) {
            throw IllegalStateException(ErrorMessage.NOT_NUMBER_RANGE_BONUS_NUMBER.message)
        }
        val numbers = winningNumbers.convertToInt()
        if (numbers.contains(bonusNumber)) {
            throw IllegalStateException(ErrorMessage.NOT_DUPLICATED_BONUS_NUMBER.message)
        }

    }

    fun loadBonusNumber() = bonusNumber
}