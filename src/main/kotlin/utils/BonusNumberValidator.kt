package utils

import lotto.LottoMachine

class BonusNumberValidator : IntegerInputValidator() {

    fun checkInputValidation(userInput: String): Boolean {
        this.validateIsString(userInput)
        validateOutOfRange(userInput.toInt())
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
}