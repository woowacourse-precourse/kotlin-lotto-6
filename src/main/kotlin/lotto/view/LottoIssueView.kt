package lotto.view

import lotto.constants.GuideMessage.SHOW_ISSUED_AMOUNT

object LottoIssueView {

  fun printIssuedAmountMessage(purchaseAmount: Int) {
    println(SHOW_ISSUED_AMOUNT.format(purchaseAmount))
  }

  fun printIssuedLotto() {

  }
}