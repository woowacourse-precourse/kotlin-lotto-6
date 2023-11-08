package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.GuideMessage
import lotto.utils.LottoPurchaseExceptionHandler

object LottoPurchaseView {
  fun printPurchaseMoneyInputMessage() {
    println(GuideMessage.ENTER_PURCHASE_MONEY)
  }

  fun inputPurchaseMoney(): Long {
    val inputPurchaseMoney: String = Console.readLine()

    var validatedPurchaseMoney: Long = try {
      LottoPurchaseExceptionHandler.validateInputPurchaseMoney(inputPurchaseMoney)
    } catch (e: IllegalArgumentException) {
      ExceptionView.printExceptionMessage(e)
      inputPurchaseMoney()
    }

    return validatedPurchaseMoney
  }
}