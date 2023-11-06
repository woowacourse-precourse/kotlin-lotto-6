package lotto.controller

import lotto.model.LottoNumber
import lotto.model.LottoWinningRankCalculator
import lotto.model.ProfitCalculator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoNumber: LottoNumber,
    private val lottoWinningRankCalculator: LottoWinningRankCalculator,
    private val profitCalculator: ProfitCalculator
) {
    fun run() {
        outputView.printInputPriceMessage()
        val amount = inputView.inputPurchaseAmount()
        val lottoTicketCount = amount / 1000
        outputView.printPurchaseNumberMessage(lottoTicketCount)
        val lotteryTickets = lottoNumber.generateLotto(lottoTicketCount)
        outputView.printInputWinNumberMessage()
        val winNumber = inputView.inputWinNumber()
        outputView.printInputBonusNumberMessage()
        val bonusNumber = inputView.inputBonusNumber()
        outputView.printWinStaticsMessage()
        val wonLotto = lottoWinningRankCalculator.calculateRank(amount, lotteryTickets, winNumber, bonusNumber)
        outputView.printWinStats(wonLotto)
        val profitRate = profitCalculator.calculateProfitRate(amount, lottoWinningRankCalculator.prize)
        outputView.printProfitRate(profitRate)
    }
}