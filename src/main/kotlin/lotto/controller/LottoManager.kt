package lotto.controller

import lotto.Lotto
import lotto.domain.*
import lotto.view.OutputView

class LottoManager(private val outputView: OutputView) {
    fun run() {
        val lottoPurchase = LottoPurchase()
        val amount = lottoPurchase.buyLotto()
        val ticket = lottoPurchase.calculateTicket(amount)
        outputView.showBuyTicketMessage(ticket)

        val lottoWrapper = LottoWrapper()
        val lottoList = lottoWrapper.repeatLottoNumbers(ticket)

        outputView.showLottoNumbers(lottoList)

        val lottoWinning = LottoWinning()
        val winningNumbers = lottoWinning.createWinningLotto()

        val lotto = Lotto(winningNumbers)

        val bonus = LottoBonus()
        val bonusNumber = bonus.createBonusNumber(winningNumbers)


        outputView.showWinningStatisticsMessages()
        val ranks = LottoRanks()

        var results = mutableMapOf<Prize, Int>()
        lottoList.forEach {
            results = ranks.rank(it.getLotto(), lotto, bonusNumber)
        }
        val yield = LottoYield()
        val profitPercentage = yield.calculateLottoYield(results, amount)

        outputView.printResults(results)
        outputView.printProfitPercentage(profitPercentage)
    }
}