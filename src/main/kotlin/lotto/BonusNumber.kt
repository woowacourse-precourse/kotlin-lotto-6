package lotto

import camp.nextstep.edu.missionutils.Console
import exception.Exception
import exception.Message
import ui.Input
import ui.Output

class BonusNumber {
    init {
        Output.printInputBonusNumber()
    }

    fun createBonusNumber(userLotto: Lotto): Int {
        val bonusNumber = Input.inputBonusNumber()
        checkValidBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }

    fun checkValidBonusNumber(bonusNumber: String) {
        if (bonusNumber.toInt() !in 1..45) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_BONUS_NUMBER)
        }
        if (!bonusNumber.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_NUMBER)
        }
    }

}