package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmountPrompt(): String {
        println(PURCHASE_AMOUNT_MESSAGE)

        val inputData = Console.readLine()
        inputData.validateEmpty(PURCHASE_AMOUNT_EMPTY)

        return inputData
    }

    fun String.validateEmpty(errorMessage: String) = require(this != "") { errorMessage }

    companion object {
        private const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val PURCHASE_AMOUNT_EMPTY = "구입금액이 입력되지 않았습니다."
    }
}