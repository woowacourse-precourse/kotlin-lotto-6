package lotto.controller

import LottoView.inputPurchaseAmountOfLotto
import LottoView.printPurchaseAmountOfLotto
import lotto.model.LottoModel

class LottoController() {
    private val lottoModel = LottoModel()
    fun start() {
        printPurchaseAmountOfLotto()
        val purchaseAmount = inputPurchaseAmountOfLotto()
    }
}