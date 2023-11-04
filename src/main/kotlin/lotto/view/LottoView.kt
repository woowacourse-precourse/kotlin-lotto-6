package lotto.view

import util.Validator

class LottoView {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator

    fun getPurchaseAmount(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            val purchaseAmount = inputView.inputPurchaseAmount()
            validator.validatePurchaseAmount(purchaseAmount)
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printPurchaseAmountErrorMessage(illegalArgumentException.message.toString())
            getPurchaseAmount()
        }
    }
}