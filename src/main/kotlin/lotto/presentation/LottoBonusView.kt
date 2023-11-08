package lotto.presentation

import BONUS_NUMBER_MESSAGE
import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoBonusView {
    fun printBonusNumberOfLotto() {
        println(BONUS_NUMBER_MESSAGE)
    }

    fun inputBonusNumberOfLotto(winningNumber: List<Int>): Int {
        val bonusNumber = Console.readLine()
        LottoController().validateBonusNumberNumeric(bonusNumber)
        LottoController().validateBonusNumberRange(bonusNumber.toInt())
        LottoController().validateBonusNumberDuplication(bonusNumber.toInt(), winningNumber)

        return bonusNumber.toInt()
    }
}