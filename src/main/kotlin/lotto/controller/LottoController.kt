package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoModel
import lotto.view.LottoView
import java.lang.NumberFormatException

class LottoController(private val view: LottoView, private val model: LottoModel) {
    fun run() {
        view.requestPurchaseMoneyValueMessage()
        while (model.isPurchaseMoneyValueValid(setPurchaseMoneyValue())) {
            view.displayInappropriateValueError()
        }
        view.displayPurchasedLotteryAmountMessage(model.getLotteryAmount())
        model.setLotteryNumbers()
        view.displayLotteryNumbers(model.getLotteryNumbers())
        view.requestWinningNumbersMessage()
        while (model.setLotto(setWinningNumbers())) {
            view.displayInappropriateLottoNumberError()
        }
        view.requestBonusNumberMessage()
        while (model.setBonus(setBonusNumber())) {
            view.displayInappropriateBonusValueERROR()
        }
        view.displayLotteryStatisticsMessage()

    }
    private fun setPurchaseMoneyValue(): String {
        return Console.readLine()
    }
    private fun setWinningNumbers(): List<String> {
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }
    private fun setBonusNumber(): String {
            return Console.readLine()
    }
}