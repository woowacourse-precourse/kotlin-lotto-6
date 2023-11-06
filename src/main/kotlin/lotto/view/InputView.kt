package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_LOTTO = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    fun inputPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine()
    }

    fun inputWinningLotto(): List<String> {
        println(System.lineSeparator() + INPUT_WINNING_LOTTO)
        return Console.readLine().split(",")
    }

    fun inputBonusNumber(): String {
        println(System.lineSeparator() + INPUT_BONUS_NUMBER)
        return Console.readLine()
    }
}