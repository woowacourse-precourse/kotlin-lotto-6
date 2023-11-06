package lotto

import camp.nextstep.edu.missionutils.Console
import exception.Exception
import exception.Message
import ui.Input

class BonusNumber {
    init {
        Message.MESSAGE_INPUT_BONUS_NUMBER
    }

    fun createBonusNumber(): Int {
        val bonusNumber = Input.inputBonusNumber()
        checkValidBonusNumber(bonusNumber)
        return bonusNumber
    }

    fun checkValidBonusNumber(bonusNumber: Int) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_BONUS_NUMBER)
        }
    }
}