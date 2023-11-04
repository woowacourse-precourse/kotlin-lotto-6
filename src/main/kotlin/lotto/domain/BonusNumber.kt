package lotto.domain

import lotto.Input
import lotto.constant.Constant
import lotto.constant.OutputMessage
import lotto.constant.Exception

object BonusNumber {

    private var bonusNumber = Constant.BONUS_NUMBER_INIT
    init {
        println(OutputMessage.MESSAGE_INPUT_BONUS_NUMBER)
    }

    fun getBonusNumber(): Int{
        return bonusNumber
    }
    fun inputBonusNumber() {
        var validCheck = false
        while(!validCheck) {
            val bonusNumberBeforeCheck = Input.inputInt()
            try {
                checkValidationBonusNumber(bonusNumberBeforeCheck)
                validCheck = true
                bonusNumber = bonusNumberBeforeCheck.toInt()
            } catch (e: IllegalArgumentException) { }
        }
    }

    private fun checkValidationBonusNumber(bonusNumber: String) {
        checkDigitBonusNumber(bonusNumber)
        checkRangeBonusNumber(bonusNumber)
        checkDuplicateBonusNumberWithWinningNumber(bonusNumber)
    }

    private fun checkDigitBonusNumber(bonusNumber: String) {
        if(!bonusNumber.all { Character.isDigit(it) }) {
            println(Exception.MESSAGE_EXCEPT_DIGIT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DIGIT)
        }
    }

    private fun checkRangeBonusNumber(bonusNumber: String) {
        if(bonusNumber.toInt() !in Constant.MIN_LOTTO_NUMBER..Constant.MAX_LOTTO_NUMBER) {
            println(Exception.MESSAGE_EXCEPT_RANGE)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_RANGE)
        }
    }

    private fun checkDuplicateBonusNumberWithWinningNumber(bonusNumber: String) {
        if(WinningNumber.getWinningNumbers().contains(bonusNumber.toInt())) {
            println(Exception.MESSAGE_EXCEPT_DUPLICATE_BONUS_WINNING_NUMBER)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DUPLICATE_BONUS_WINNING_NUMBER)
        }
    }
}