package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoBank
import lotto.model.LottoGenerator
import lotto.model.LottoRanking.Companion.calculateMatchingLottoRank
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager {
    val lottoGenerator = LottoGenerator()
    val lottoBank = LottoBank()

    val outputView = OutputView()
    val inputView = InputView()


    fun runApplication() {
        val purchasedLottoCount = runPurchaseLottoAmount()
        val purchasedLottoList =  mutableListOf<Lotto>()
        (1..purchasedLottoCount).forEach { _ ->
            purchasedLottoList.add(lottoGenerator.createLotto())
        }
        runPrintLottoList(purchasedLottoCount, purchasedLottoList)
        val lottoWinningNumberAndBonusNumber = runInputLottoNumbers()
        val lottoWinningNumbers = lottoWinningNumberAndBonusNumber.first
        val lottoBonusNumber = lottoWinningNumberAndBonusNumber.second
        runCalculateMatchingLottoRank(lottoWinningNumbers, lottoBonusNumber, purchasedLottoList)

        val rateOfReturn = lottoBank.getRateOfReturn(purchasedLottoCount)
        runPrintWinningLottoStatistics(rateOfReturn)

    }

    fun runPurchaseLottoAmount(): Int {
        var purchasedLottoCount = 0
        try {
            outputView.askPurchaseLottoAmount()
            purchasedLottoCount = inputView.inputPurchaseLottoAmount()
            outputView.printLineBreaking()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            runPurchaseLottoAmount()
        }
        return purchasedLottoCount
    }

    fun runPrintLottoList(purchasedLottoCount: Int, purchasedLottoList: List<Lotto>) {
        outputView.printLottoList(purchasedLottoCount, purchasedLottoList)
        outputView.printLineBreaking()
    }

    fun runInputLottoNumbers(): Pair<Lotto, Int> {
        outputView.askLottoWinningNumbers()
        val lottoWinningNumbers = inputView.inputLottoWinningNumbers()
        outputView.printLineBreaking()

        outputView.askLottoBonusNumber()
        val lottoBonusNumber = inputView.inputLottoBonusNumber()
        outputView.printLineBreaking()

        return Pair(lottoWinningNumbers, lottoBonusNumber)
    }

    fun runCalculateMatchingLottoRank(lottoWinningNumbers: Lotto, lottoBonusNumber: Int, userLottoList: List<Lotto>){
        calculateMatchingLottoRank(lottoWinningNumbers, lottoBonusNumber, userLottoList)
    }
    fun runPrintWinningLottoStatistics(rateOfReturn: Double){
        outputView.printWinningLottoStatistics(rateOfReturn)
    }
}