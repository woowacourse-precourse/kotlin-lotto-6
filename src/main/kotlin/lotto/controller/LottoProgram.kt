package lotto.controller

import lotto.Lotto
import lotto.model.LottoPublisher
import lotto.model.LottoTicketCount
import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoPublisher = LottoPublisher()
    fun run() {
        outputView.printPurchaseAmount()

        val userInput = inputView.getValidPurchaseAmount()
        val lottoTicketCount = LottoTicketCount(userInput)
        val lottoCount = lottoTicketCount.lottoCount

        outputView.printLottoCount(lottoCount)
        lottoPublisher.publishLottoList(lottoCount)
        outputView.printLottoList(lottoPublisher.publishedLottoList)
        outputView.printRequireWinningNums()

        val winningNums = inputView.getValidWinningNums()

        val lotto = Lotto(winningNums)
    }

    companion object {
        const val LOTTO_PURCHASE_COST = 1000
    }
}