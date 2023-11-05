package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."

    fun getPurchaseMoney(): Int {
        println(PURCHASE_MONEY_MESSAGE)
        val inputPurchaseMoney = Console.readLine()

        return inputPurchaseMoney.toInt()
    }
}