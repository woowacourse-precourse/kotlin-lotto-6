package lotto.presentation

import BONUS_NUMBER_MESSAGE
import camp.nextstep.edu.missionutils.Console

object LottoBonusView {
    fun printBonusNumberOfLotto() {
        println(BONUS_NUMBER_MESSAGE)
    }

    fun inputBonusNumberOfLotto() {
        val bonusNumber = Console.readLine()
        println(bonusNumber)
    }
}