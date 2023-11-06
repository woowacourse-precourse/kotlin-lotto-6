package lotto.presentation

import camp.nextstep.edu.missionutils.Console

class DrawScreen {
    fun outputRequestDrawNumber() {
        println(REQUEST_DRAW_NUMBER_MESSAGE)
    }

    fun inputDrawNumber(): String {
        return Console.readLine()
    }

    fun outputRequestBonusNumber() {
        println(REQUEST_BONUS_NUMBER_MESSAGE)
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }

    companion object {
        const val REQUEST_DRAW_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}