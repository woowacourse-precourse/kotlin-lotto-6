package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoModel
import lotto.view.LottoView

class LottoController(private val view: LottoView, private val model: LottoModel) {
    fun run() {
        buyLottoPhase()
        setLottoNumbersPhase()
        displayResultPhase()
    }
    private fun buyLottoPhase() {
        view.requestPurchaseMoneyValueMessage()
        while (model.isPurchaseMoneyValueValid(setPurchaseMoneyValue())) {
            view.displayInappropriateValueError()
        }
        view.displayPurchasedLotteryAmountMessage(model.getLotteryAmount())
    }
    private fun setLottoNumbersPhase() {
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
    }
    private fun displayResultPhase() {
        view.displayLotteryStatisticsMessage()
        model.calculateWinningLottery()
        view.displayWinningResult(model.getLottoResult())
        model.setBenefitRate()
        view.displayBenefitRate(model.getBenefitRate())
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