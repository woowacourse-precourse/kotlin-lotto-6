package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."

    fun inputPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine()
    }
}