package lotto.controller

import INVALID_NUMERIC_MESSAGE
import LottoView.inputPurchaseAmountOfLotto
import LottoView.printPurchaseAmountOfLotto
import lotto.model.LottoModel

class LottoController() {
    private val lottoModel = LottoModel()
    fun start() {

        printPurchaseAmountOfLotto()
        val purchaseAmount = inputPurchaseAmountOfLotto()

        if (!lottoModel.isPurchaseAmountNumeric(purchaseAmount)) {
            LottoView.printErrorMessage(INVALID_NUMERIC_MESSAGE)
            start()
        }

    }
}