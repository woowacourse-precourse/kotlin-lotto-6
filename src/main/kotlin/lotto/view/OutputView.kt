package lotto.view

import lotto.view.Constant.INPUT_PRICE_MESSAGE

class OutputView {
    fun printInputPriceMessage() = println("$INPUT_PRICE_MESSAGE")
}

object Constant {
    const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
}