package lotto.controller

import lotto.Lotto
import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val lottoPurchase = LottoPurchase()
        val amount = lottoPurchase.buyLotto()
        val ticket = lottoPurchase.calculateTicket(amount)
        outputView.showBuyTicketMessage(ticket)

        val lottoWrapper = LottoWrapper()
        val lottoList = lottoWrapper.reapeatLottoNumbers(ticket)

        outputView.showLottoNumbers(lottoList)

        val lottoWinning = LottoWinning()
        val winningNumbers = lottoWinning.createWinningLotto()

        val lotto = Lotto(winningNumbers)

        val bonus = LottoBonus()
        val bonusNumber = bonus.createBonusNumber(winningNumbers)

        outputView.showWinningStatisticsMessages()
        val ranks = LottoRanks()

        var results = mutableMapOf<Prize, Int>()
        lottoList.forEach { it ->
            results = ranks.rank(it.getLotto(), lotto, bonusNumber)
        }

        outputView.printResults(results)
    }
}