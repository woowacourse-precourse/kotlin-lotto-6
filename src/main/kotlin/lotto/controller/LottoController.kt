package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.model.LottoModel
import lotto.enums.Exception
import lotto.view.LottoView

class LottoController(private val lottoModel: LottoModel,private val lottoView: LottoView) {

    fun stratLotto() {
        lottoView.printEnterPurchaseMessage()
        inputPurchaseAmount()
    }

    private fun inputPurchaseAmount() {
        while (true) {
            try {
                lottoModel.returnValue(checkPurchaseAmount(readLine()))
                break
            } catch (e: IllegalArgumentException) {
                println("${Exception.ERROR_HEADER.message} ${e.message}")
                lottoView.printEnterPurchaseMessage()
            }
        }
    }

    private fun checkPurchaseAmount(purchaseAmount: String): Int {
        require(purchaseAmount.isNotBlank() && purchaseAmount.isNotEmpty()) { Exception.INPUT_IS_BLANK.message }
        require(purchaseAmount.all { it.isDigit() }) { Exception.NOT_NUMBER.message }
        val amount = purchaseAmount.toInt()
        require(amount > 0 && amount % 1000 == 0) { Exception.AMOUNT_MUST_BE_THOUSAND_WON.message }
        return amount
    }
}