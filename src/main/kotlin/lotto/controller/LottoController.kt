package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import util.Constants.LOTTO_AMOUNT_UNIT
import util.Validator.validatePurchaseAmount

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val numberOfPurchase = getNumberOfPurchase()
    }

    fun getNumberOfPurchase(): Int {
        outputView.printPurchaseAmountInstruction()
        return try {
            val purchaseAmount = inputView.inputPurchaseAmount()
            validatePurchaseAmount(purchaseAmount) / LOTTO_AMOUNT_UNIT
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printPurchaseAmountErrorMessage(illegalArgumentException.message.toString())
            getNumberOfPurchase()
        }
    }
}