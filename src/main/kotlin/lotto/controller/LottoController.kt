package lotto.controller

import INVALID_NUMERIC_MESSAGE
import INVALID_POSITIVE_MESSAGE
import LottoView
import LottoView.inputPurchaseAmountOfLotto
import LottoView.printPurchaseAmountOfLotto
import lotto.model.LottoModel

class LottoController() {
    private val lottoModel = LottoModel()
    fun start() {

        printPurchaseAmountOfLotto()
        val purchaseAmount = inputPurchaseAmountOfLotto()

        isReStart(purchaseAmount)
    }

    private fun isReStart(input: String) {
        if (!lottoModel.isPurchaseAmountNumeric(input)) {
            LottoView.printErrorMessage(INVALID_NUMERIC_MESSAGE)
            start()
        } else if (!lottoModel.isPurchaseAmountPositive(input.toInt())) {
            LottoView.printErrorMessage(INVALID_POSITIVE_MESSAGE)
            start()
        }
    }
}