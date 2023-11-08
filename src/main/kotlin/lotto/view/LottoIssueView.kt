package lotto.view

import lotto.constants.GuideMessage.SHOW_ISSUED_AMOUNT
import lotto.domain.Lotto

object LottoIssueView {

  fun printIssuedAmountMessage(purchaseAmount: Int) {
    println(SHOW_ISSUED_AMOUNT.format(purchaseAmount))
  }

  fun printIssuedLotto(issuedLottos: List<Lotto>) {
    for (lotto in issuedLottos) {
      println(lotto.getLottoNumbers())
    }
    println()
  }
}