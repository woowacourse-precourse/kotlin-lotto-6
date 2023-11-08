package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.GuideMessage
import lotto.utils.ExceptionHandler

object LottoPurchaseView {
  fun printPurchaseMoneyInputMessage() {
    println(GuideMessage.ENTER_PURCHASE_MONEY)
  }

  fun inputPurchaseMoney(): Long {
    val inputPurchaseMoney: String = Console.readLine()
    var validatedPurchaseMoney: Long = -1L

    try {
      validatedPurchaseMoney = ExceptionHandler.validateInputPurchaseMoney(inputPurchaseMoney)
    } catch (e: IllegalArgumentException) {
      ExceptionView.printPurchaseMoneyExceptionMessage(e)
      inputPurchaseMoney()
    }

    return validatedPurchaseMoney
  }
}