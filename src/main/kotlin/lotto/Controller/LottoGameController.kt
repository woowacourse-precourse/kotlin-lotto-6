package lotto.Controller

import lotto.Model.Lotto
import lotto.View.InputView
import lotto.View.OutputView
import lotto.domain.LottoGame
import lotto.Model.LottoWinningResult

class LottoGameController(
    private val inputView : InputView,
    private val outputView : OutputView,
    private val lottoGame: LottoGame,
) {
    fun start() {
        playLottoGame()
    }

    fun playLottoGame() {
        outputView.printPurchaseLottoPrice()
        val purchaseAmount = inputView.purchaseLottoPrice()
        val lottoQuantity = lottoGame.getQuantity(purchaseAmount)
        val lottoNumbers = lottoGame.createRandomLottoNumbers(lottoQuantity)
        outputView.printLottoQuantity(lottoNumbers.size)
        outputView.printLottoNumbers(lottoNumbers)

        outputView.printWinningNumbers()
        val winningNumber = inputView.getWinningNumbers()
        outputView.printBonusNumber()
        val bonusNumber = inputView.getBonusNumber(winningNumber)

        processGame(purchaseAmount, lottoNumbers, winningNumber, bonusNumber)
    }

    private fun processGame(purchaseAmount: Int, lottoNumbers: List<Lotto>, winningNumber: Lotto, bonusNumber: Int) {
        val lottoResults = lottoGame.getLottoResults(lottoNumbers, winningNumber, bonusNumber)
        val lottoMatchResult = lottoGame.getLottoMatchResult(lottoResults)
        val rate = lottoGame.calculateRate(lottoMatchResult, purchaseAmount)
        val winningDetails = LottoWinningResult(lottoMatchResult, rate)

        // 결과 출력
        outputView.printWinningDetails(winningDetails)
    }

}