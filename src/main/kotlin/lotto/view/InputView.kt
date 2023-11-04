package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmountPrompt(): String {
        println(purchaseAmountMessage)
        return Console.readLine()
    }

    companion object {
        private const val purchaseAmountMessage = "구입금액을 입력해 주세요."
    }
}