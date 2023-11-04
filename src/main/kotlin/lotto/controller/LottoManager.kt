package controller

import lotto.Lotto
import lotto.domain.Bonus
import lotto.domain.LottoWrapper
import lotto.domain.Purchase
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val purchase = Purchase()
        val amount = purchase.buyLotto()
        val ticket = purchase.calculateTicket(amount)
        outputView.showBuyTicketMessage(ticket)

        val lottoWrapper = LottoWrapper()
        val lottoList = lottoWrapper.reapeatLottoNumbers(ticket)

        outputView.showLottoNumbers(lottoList)

        val winningLotto = WinningLotto()
        val winningNumbers = winningLotto.createWinningLotto()

        val lotto = Lotto(winningNumbers)

        val bonus = Bonus()
        bonus.createBonusNumber(winningNumbers)
    }

    fun compareLottoNumbers(lotto: Lotto, winningNumbers: List<Int>) {
        var count = 0
        for (winningNumber in winningNumbers) {
            if (lotto.getLotto().contains(winningNumber)) {
                count++
            }
        }
        println(count)
    }






}