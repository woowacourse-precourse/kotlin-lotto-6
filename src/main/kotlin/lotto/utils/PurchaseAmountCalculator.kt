package lotto.utils

import lotto.constants.Lotto

object PurchaseAmountCalculator {
  fun calculatePurchaseAmount(purchaseMoney: Long): Long {
    return purchaseMoney / Lotto.LOTTO_PRICE
  }
}