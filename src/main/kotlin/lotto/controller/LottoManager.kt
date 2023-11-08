package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoBank
import lotto.model.LottoGenerator
import lotto.model.LottoRanking.Companion.calculateMatchingLottoRank
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager {
    private val lottoGenerator = LottoGenerator()
    private val lottoBank = LottoBank()

    private val outputView = OutputView()
    private val inputView = InputView()


    fun runApplication() {
        val purchasedLottoCount = runPurchaseLottoAmount()
        val purchasedLottoList =  mutableListOf<Lotto>()
        (1..purchasedLottoCount).forEach { _ ->
            purchasedLottoList.add(lottoGenerator.createLotto())
        }
        runPrintLottoList(purchasedLottoCount, purchasedLottoList)
        val lottoWinningNumbers = runInputLottoWinningNumbers()
        val winningLotto = runInputLottoBonusNumbers(lottoWinningNumbers)
        runCalculateMatchingLottoRank(winningLotto.getLottoWinningNumbers(), winningLotto.getLottoBonusNumber(), purchasedLottoList)
        val rateOfReturn = lottoBank.getRateOfReturn(purchasedLottoCount)
        runPrintWinningLottoStatistics(rateOfReturn)
    }

    fun runPurchaseLottoAmount(): Int {
        var purchasedLottoCount: Int? = null
        try {
            outputView.askPurchaseLottoAmount()
            purchasedLottoCount = inputView.inputPurchaseLottoAmount()
            outputView.printLineBreaking()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            outputView.printLineBreaking()
            purchasedLottoCount = runPurchaseLottoAmount()
        }
        return purchasedLottoCount!!
    }

    fun runPrintLottoList(purchasedLottoCount: Int, purchasedLottoList: List<Lotto>) {
        outputView.printLottoList(purchasedLottoCount, purchasedLottoList)
        outputView.printLineBreaking()
    }

    fun runInputLottoWinningNumbers(): Lotto {
        var lottoWinningNumbers: Lotto? = null
        try {
            outputView.askLottoWinningNumbers()
            lottoWinningNumbers = inputView.inputLottoWinningNumbers()
            outputView.printLineBreaking()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            outputView.printLineBreaking()
            lottoWinningNumbers = runInputLottoWinningNumbers()
        }
        return lottoWinningNumbers!!
    }

    fun runInputLottoBonusNumbers(lottoWinningNumbers: Lotto): WinningLotto {
        var lottoBonusNumber: Int? = null
        var winningLotto: WinningLotto? = null
        try {
            outputView.askLottoBonusNumber()
            lottoBonusNumber = inputView.inputLottoBonusNumber()
            winningLotto = WinningLotto(lottoWinningNumbers, lottoBonusNumber)
            outputView.printLineBreaking()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            outputView.printLineBreaking()
            winningLotto = runInputLottoBonusNumbers(lottoWinningNumbers)
        }
        return winningLotto!!
    }

    fun runCalculateMatchingLottoRank(lottoWinningNumbers: Lotto, lottoBonusNumber: Int, userLottoList: List<Lotto>){
        calculateMatchingLottoRank(lottoWinningNumbers, lottoBonusNumber, userLottoList)
    }
    fun runPrintWinningLottoStatistics(rateOfReturn: Double){
        outputView.printWinningLottoStatistics(rateOfReturn)
    }
}