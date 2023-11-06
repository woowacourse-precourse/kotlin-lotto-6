package lotto.controller

import LottoView.inputPurchaseAmountOfLotto
import LottoView.printPurchaseAmountOfLotto
import lotto.model.LottoModel
import java.util.*

class LottoController() {
    private val lottoModel = LottoModel()
    fun start() {
        try {
            printPurchaseAmountOfLotto()
            val purchaseAmount = inputPurchaseAmountOfLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            start()
        }
    }

    fun validateInputNumeric(input: String) {
        lottoModel.isPurchaseAmountNumeric(input)
    }

    fun validateInputPositive(input: Int) {
        lottoModel.isPurchaseAmountPositive(input)
    }

    fun validateInputDivisionPrice(input: Int) {
        lottoModel.isDivisibleBy1000(input)
    }
}