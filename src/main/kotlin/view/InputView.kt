package view

import camp.nextstep.edu.missionutils.Console
import validator.purchaseamountvalidator.PurchaseAmountValidator

object InputView {

    fun lottoPurchaseAmount(): Int {
        val lottoPurchaseAmount = Console.readLine()

        try {
            PurchaseAmountValidator.isAppropriatePurchaseAmount(lottoPurchaseAmount)
        } catch (e: IllegalArgumentException) {
            return lottoPurchaseAmount()
        }

        return lottoPurchaseAmount.toInt()
    }
}
