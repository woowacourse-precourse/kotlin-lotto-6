package lotto.presentation

import camp.nextstep.edu.missionutils.Console

class DrawScreen {
    fun outputRequestDrawNumber() = println(LINE_SEPARATOR + REQUEST_DRAW_NUMBER_MESSAGE)

    fun inputDrawNumber(): String = Console.readLine()

    fun outputRequestBonusNumber() = println(LINE_SEPARATOR + REQUEST_BONUS_NUMBER_MESSAGE)

    fun inputBonusNumber(): String = Console.readLine()

    companion object {
        const val REQUEST_DRAW_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        const val LINE_SEPARATOR = "\n"
    }
}