package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.GuideMessage

class LottoPurchaseView {
  fun printPurchaseMoneyInputMessage() {
    println(GuideMessage.ENTER_PURCHASE_MONEY)
  }

  fun inputPurchaseMoney(): Int {
    val input: String = Console.readLine().trim()

    try {
      TODO("예외처리 로직 필요")
    } catch (e: IllegalArgumentException) {
      TODO("Int형의 purchaseMoney 리턴 필요")
    } finally {
      TODO("그 부분부터 입력을 다시 받는 기능")
    }
  }
}