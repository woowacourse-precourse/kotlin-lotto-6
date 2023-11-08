package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.GuideMessage
import lotto.utils.ExceptionHandler

class LottoPurchaseView {
  fun printPurchaseMoneyInputMessage() {
    println(GuideMessage.ENTER_PURCHASE_MONEY)
  }

  fun inputPurchaseMoney(): Long {
    val inputPurchaseMoney: String = Console.readLine()

    try {
      val validatedPurchaseMoney = ExceptionHandler.validateInputPurchaseMoney(inputPurchaseMoney)
    } catch (e: IllegalArgumentException) {
      TODO("오류 메시지 출력 기능")
      TODO("그 부분부터 입력을 다시 받는 기능")
    }
    return TODO("Provide the return Long형의 purchaseMoney value")
  }
}