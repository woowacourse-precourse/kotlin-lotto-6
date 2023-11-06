package lotto.controller

import lotto.model.LottoResultAnalyzer
import lotto.model.Lotto
import lotto.model.LottoPublisher
import lotto.model.LottoTicketCount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoPublisher = LottoPublisher()

    fun run() {
        val purchaseAmount = requestPurchaseAmount()
        val lottoQuantity = countAndPrintLottoQuantity(purchaseAmount)
        publishAndPrintLotto(lottoQuantity)
        val winningNums = requestWinningNums()
        val lotto = Lotto(winningNums)
        val bonusNum = requestBonusNum(winningNums)
        analyzeAndPrintLottoResults(lotto, bonusNum, purchaseAmount)
    }

    private fun requestPurchaseAmount(): String {
        outputView.printRequestPurchaseAmount()
        return inputView.getValidPurchaseAmount()
    }

    private fun countAndPrintLottoQuantity(purchaseAmount: String): Int {
        val lottoTicketCounter = LottoTicketCount(purchaseAmount)
        val lottoCount = lottoTicketCounter.lottoCount
        outputView.printLottoCount(lottoCount)
        return lottoCount
    }

    private fun requestWinningNums(): List<Int> {
        //당첨번호 입력
        outputView.printRequestWinningNums()
        return inputView.getValidWinningNums()
    }

    private fun requestBonusNum(winningNums: List<Int>): Int {
        outputView.printRequestBonusNums()
        return inputView.getValidBonusNum(winningNums)
    }

    private fun publishAndPrintLotto(lottoQuantity: Int) {
        lottoPublisher.publishLottoList(lottoQuantity)
        outputView.printLottoList(lottoPublisher.publishedLottoList)
    }

    private fun analyzeAndPrintLottoResults(lotto: Lotto, bonusNum: Int, purchaseAmount: String) {
        val lottoResult = lotto.checkLottoWinning(bonusNum, lottoPublisher.publishedLottoList)
        val lottoResultAnalyzer = LottoResultAnalyzer()
        lottoResultAnalyzer.analyzeLottoResults(lottoResult)
        lottoResultAnalyzer.calculateProfitRate(purchaseAmount.toInt())
        outputView.printWinningStats(lottoResultAnalyzer.analyzedLottoResults, lottoResultAnalyzer.profitRate)
    }
}