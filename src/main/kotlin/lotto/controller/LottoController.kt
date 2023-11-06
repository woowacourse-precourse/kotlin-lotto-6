package lotto.controller

import lotto.model.LottoNumber
import lotto.model.LottoWinningRankCalculator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoNumber: LottoNumber,
    private val lottoWinningRankCalculator: LottoWinningRankCalculator
) {
    fun run() {
        outputView.printInputPriceMessage()
        val number = inputView.inputPurchaseAmount()
        outputView.printPurchaseNumberMessage(number)
        val lotteryTickets = lottoNumber.generateLotto(number)
        outputView.printInputWinNumberMessage()
        val winNumber = inputView.inputWinNumber()
        outputView.printInputBonusNumberMessage()
        val bonusNumber = inputView.inputBonusNumber()
        outputView.printWinStaticsMessage()
        val wonLotto = lottoWinningRankCalculator.calculateRank(lotteryTickets,winNumber,bonusNumber)
        outputView.printWinStats(wonLotto)

    }

}