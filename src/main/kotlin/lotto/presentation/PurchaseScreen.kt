package lotto.presentation

import camp.nextstep.edu.missionutils.Console

class PurchaseScreen {
    fun outputRequestAmount() = println(PROMPT_AMOUNT_MESSAGE)

    fun inputAmount(): String = Console.readLine()

    companion object {
        const val PROMPT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    }
}