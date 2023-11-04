package lotto.view

import lotto.Lotto
import lotto.view.Constant.INPUT_PRICE_MESSAGE
import lotto.view.Constant.PURCHASE_NUMBER

class OutputView {
    fun printInputPriceMessage() = println("$INPUT_PRICE_MESSAGE")

    fun printPurchaseNumber(number: Int) = println("\n$number$PURCHASE_NUMBER")

    fun printLotto(lotto: List<Int>) = println(lotto)
}

object Constant {
    const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    const val PURCHASE_NUMBER = "개를 구매했습니다."
}