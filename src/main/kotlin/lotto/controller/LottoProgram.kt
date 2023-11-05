package lotto.controller

import lotto.model.LottoResultAnalyzer
import lotto.model.Lotto
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

        outputView.printRequireBonusNums()
        val bonusNum = inputView.getValidBonusNum(winningNums)
        val lottoResult = lotto.checkLottoWinning(bonusNum, lottoPublisher.publishedLottoList)
        val lottoResultAnalyzer = LottoResultAnalyzer()
        lottoResultAnalyzer.analyzeLottoResults(lottoResult)
        val analyzedResult = lottoResultAnalyzer.getAnalyzedLottoResults()
        println(analyzedResult)
    }

    companion object {
        const val LOTTO_PURCHASE_COST = 1000
    }
}