package lotto

class BonusNumber (bonusNumber: Int, winningLotteryNumbers: List<Int>) {
    init {
        validateBonusNumber(bonusNumber, winningLotteryNumbers)
    }

    companion object {
        const val BONUS_NUM_START = 1
        const val BONUS_NUM_END = 45
    }

    private fun validateBonusNumber(bonusNumber: Int, winningLotteryNumbers: List<Int>) {
        if (bonusNumber < BONUS_NUM_START || bonusNumber > BONUS_NUM_END) {
            throw IllegalArgumentException(MessageConstants.ERROR_LESS_THAN_1_OR_MORE_THAN_45)
        }
        if (winningLotteryNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException(MessageConstants.DUPLICATE_WINNING_AND_BONUS_NUMBER)
        }
    }
}