package lotto

class BonusNumber (bonusNumber: Int, winningLotteryNumbers: List<Int>) {
    init {
        validateBonusNumber(bonusNumber, winningLotteryNumbers)
    }

    private fun validateBonusNumber(bonusNumber: Int, winningLotteryNumbers: List<Int>) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw IllegalArgumentException(MessageConstants.ERROR_LESS_THAN_1_OR_MORE_THAN_45)
        }
        if (winningLotteryNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException(MessageConstants.DUPLICATE_WINNING_AND_BONUS_NUMBER)
        }
    }
}