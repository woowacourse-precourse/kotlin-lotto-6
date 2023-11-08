package lotto.utils

import lotto.constants.Lotto

object PurchaseAmountCalculator {
  fun calculatePurchaseAmount(purchaseMoney: Long): Int {
    return (purchaseMoney / Lotto.LOTTO_PRICE).toInt()
  }
}