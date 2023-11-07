package utils

class BonusNumberValidator : IntegerInputValidator() {

    fun checkInputValidation(userInput: String, winningNumbers: List<Int>): Boolean {
        super.validateIsString(userInput)
        val bonusNumber = userInput.toInt()
        super.validateOutOfRange(bonusNumber)
        validateExistInWinningNumbers(bonusNumber, winningNumbers)
        return true
    }

    fun validateExistInWinningNumbers(bonusNumber: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber)) { DUPLICATE_WITH_WINNER_NUMBERS_ERR_MSG }
    }

    companion object {
        const val DUPLICATE_WITH_WINNER_NUMBERS_ERR_MSG = "보너스 번호는 당첨 번호와 동일한 숫자가 될 수 없습니다."
    }
}
