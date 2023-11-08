package view

import camp.nextstep.edu.missionutils.Console
import validator.bonusnumbervalidator.BonusNumberValidator
import validator.lottonumbervalidator.LottoNumberValidator
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

    fun lottoNumber(): List<Int> {
        val lottoNumber = Console.readLine()

        try {
            LottoNumberValidator.isAppropriateLottoNumber(lottoNumber)
        } catch (e: IllegalArgumentException) {
            return lottoNumber()
        }

        return lottoNumber.split(",").map { it.toInt() }
    }

    fun bonusNumber(lottoNumber: List<Int>): Int {
        val bonusNumber = Console.readLine()

        try {
            BonusNumberValidator.isAppropriateBonusNumber(bonusNumber, lottoNumber)
        } catch (e: IllegalArgumentException) {
            return bonusNumber(lottoNumber)
        }

        return bonusNumber.toInt()
    }
}