package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoModel
import lotto.view.LottoView

class LottoController(private val view: LottoView, private val model: LottoModel) {
    fun run() {
        view.requestPurchaseMoneyValueMessage()
        while (model.isPurchaseMoneyValueValid(setPurchaseMoneyValue())) {
            view.displayInappropriateValueError()
        }
        view.displayPurchasedLotteryAmountMessage(model.getLotteryAmount())
        model.setLotteryNumbers()
        view.displayLotteryNumbers(model.getLotteryNumbers())
    }

    private fun setPurchaseMoneyValue(): String {
        return Console.readLine()
    }
}