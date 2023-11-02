package lotto.domain

import lotto.Input

object BonusNumber {

    init {
        println("")
        println("보너스 번호를 입력해 주세요.")
    }

    fun getBonusNumber(): Int {
        val bonusNumber = Input.inputInt()
        checkValidationBonusNumber(bonusNumber)
        return bonusNumber
    }

    private fun checkValidationBonusNumber(bonusNumber: Int) {
        if(!(bonusNumber in 1..45))
            throw IllegalArgumentException("오류")
    }
}