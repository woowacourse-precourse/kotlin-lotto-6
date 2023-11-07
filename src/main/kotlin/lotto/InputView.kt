package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmountInput(): String {
        println(PURCHASE_AMOUNT_INPUT_STRING)
        return Console.readLine()
    }

    fun lottoNumbersInput(): String {
        println(LOTTO_NUMBERS_INPUT_STRING)
        return Console.readLine()
    }

    fun bonusNumberInput(): String {
        println(BONUS_NUMBERS_INPUT_STRING)
        return Console.readLine()
    }

    companion object {
        const val PURCHASE_AMOUNT_INPUT_STRING = "구입금액을 입력해 주세요."
        const val LOTTO_NUMBERS_INPUT_STRING = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBERS_INPUT_STRING = "보너스 번호를 입력해 주세요."
    }
}