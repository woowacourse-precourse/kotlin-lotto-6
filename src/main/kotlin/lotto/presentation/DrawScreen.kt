package lotto.presentation

import camp.nextstep.edu.missionutils.Console

class DrawScreen {
    fun outputRequestDrawNumber() {
        println(REQUEST_DRAW_NUMBER_MESSAGE)
    }

    fun inputDrawNumber(): String {
        return Console.readLine()
    }

    companion object{
        const val REQUEST_DRAW_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    }
}