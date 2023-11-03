package lotto.domain

import lotto.Input
import lotto.constant.Constant
import lotto.constant.OutputMessage
import lotto.constant.Exception

object BonusNumber {

    private var bonusNumber = 0
    init {
        println(OutputMessage.MESSAGE_INPUT_BONUS_NUMBER)
    }

    fun getBonusNumber(): Int{
        return bonusNumber
    }
    fun inputBonusNumber() {
        val bonusNumberBeforeCheck = Input.inputInt()
        checkValidationBonusNumber(bonusNumberBeforeCheck)
        bonusNumber = bonusNumberBeforeCheck.toInt()
    }

    private fun checkValidationBonusNumber(bonusNumber: String) {
        if(!bonusNumber.all { Character.isDigit(it) }) {
            println(Exception.MESSAGE_EXCEPT_DIGIT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DIGIT)
        }
        if(!(bonusNumber.toInt() in Constant.MIN_LOTTO_NUMBER..Constant.MAX_LOTTO_NUMBER)) {
            println(Exception.MESSAGE_EXCEPT_RANGE)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_RANGE)
        }
    }
}