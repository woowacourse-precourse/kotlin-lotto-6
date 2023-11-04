package lotto.view

import lotto.Lotto
import lotto.view.Constant.INPUT_BONUS_NUMBER_MESSAGE
import lotto.view.Constant.INPUT_PRICE_MESSAGE
import lotto.view.Constant.INPUT_WIN_NUMBER_MESSAGE
import lotto.view.Constant.PURCHASE_NUMBER_MESSAGE

class OutputView {
    fun printInputPriceMessage() = println("$INPUT_PRICE_MESSAGE")

    fun printPurchaseNumberMessage(number: Int) = println("\n$number$PURCHASE_NUMBER_MESSAGE")

    fun printLotto(lotto: List<Int>) = println(lotto)

    fun printInputWinNumberMessage() = println("\n$INPUT_WIN_NUMBER_MESSAGE")

    fun printInputBonusNumberMessage() = println("\n$INPUT_BONUS_NUMBER_MESSAGE")
}

object Constant {
    const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    const val PURCHASE_NUMBER_MESSAGE = "개를 구매했습니다."
    const val INPUT_WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
}