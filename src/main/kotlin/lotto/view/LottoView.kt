package lotto.view

import util.Validator

class LottoView {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator

    fun getPurchaseAmount(): Int {
        outputView.printPurchaseAmountInstruction()
        val purchaseAmount = inputView.inputPurchaseAmount()
        return validator.validatePurchaseAmount(purchaseAmount)
    }
}