package lotto

import exception.Exception
import ui.Input
import ui.Output

class BonusNumber {
    init {
        Output.printInputBonusNumber()
    }

    fun createBonusNumber(userLotto: Lotto): Int {
        try {
            val bonusNumber = Input.inputBonusNumber()
            checkValidBonusNumber(bonusNumber)
            checkDuplicateBonusNumber(userLotto, bonusNumber.toInt())
            return bonusNumber.toInt()
        } catch (e: InvalidBonusNumberException) {
            println(e.message)
            return createBonusNumber(userLotto)
        }
    }
}

class InvalidBonusNumberException(message: String) : IllegalArgumentException(message)

fun checkValidBonusNumber(bonusNumber: String) {
    val bonusNumberInt = bonusNumber.toIntOrNull()

    if (bonusNumberInt == null || bonusNumberInt !in 1..45) {
        throw InvalidBonusNumberException(Exception.EXCEPTION_INVALID_NUMBER)
    }
}

fun checkDuplicateBonusNumber(userLotto: Lotto, bonusNumber: Int) {
    val lotto = userLotto.getNumbers()
    if (lotto.contains(bonusNumber)) {
        throw InvalidBonusNumberException(Exception.EXCEPTION_DUPLICATE_BONUS_NUMBER)
    }
}


