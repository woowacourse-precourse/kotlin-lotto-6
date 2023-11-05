package utils

import lotto.LottoMachine

class BonusNumberValidator : IntegerInputValidator() {

    fun checkInputValidation(userInput: String, winningNumbers: List<Int>): Boolean {
        this.validateIsString(userInput)
        val bonusNumber = userInput.toInt()
        validateOutOfRange(bonusNumber)
        validateDuplicateValueWithWinningNumber(bonusNumber, winningNumbers)
        return true
    }

    fun validateOutOfRange(number: Int) {
        require(number in LottoMachine.START_RANGE_LOTTO_NUM..LottoMachine.END_RANGE_LOTTO_NUM) {
            getInvalidRangeLottoNumErrMsg(
                LottoMachine.START_RANGE_LOTTO_NUM,
                LottoMachine.END_RANGE_LOTTO_NUM
            )
        }
    }

    fun validateDuplicateValueWithWinningNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber)) { DUPLICATE_WITH_WINNER_NUMBERS_ERR_MSG }
    }

    companion object {
        const val DUPLICATE_WITH_WINNER_NUMBERS_ERR_MSG = "보너스 번호는 당첨 번호와 동일한 숫자가 될 수 없습니다."
    }
}
