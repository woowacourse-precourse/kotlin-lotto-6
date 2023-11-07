package lotto.presentation

import BONUS_NUMBER_MESSAGE
import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoBonusView {
    fun printBonusNumberOfLotto() {
        println(BONUS_NUMBER_MESSAGE)
    }

    fun inputBonusNumberOfLotto() {
        val bonusNumber = Console.readLine()
        LottoController().validateInputBonusNumberNumeric(bonusNumber)
    }
}