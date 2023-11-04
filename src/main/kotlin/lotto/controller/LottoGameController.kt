package lotto.controller

import lotto.domain.LottoGame
import lotto.model.Lotto
import lotto.model.LottoWinningResult
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoGame: LottoGame,
) {

    fun run() {
        playLottoGame { purchaseAmount, lottoNumbers, winningNumber, bonusNumber ->
            val lottoWinningResult = processGame(purchaseAmount, lottoNumbers, winningNumber, bonusNumber)
            outputView.printLottoWinningResults(lottoWinningResult)
        }
    }

    private inline fun playLottoGame(action: (purchaseAmount: Int, lottoNumbers: List<Lotto>, winningNumber: Lotto, bonusNumber: Int) -> Unit) {
        val purchaseAmount = getInputAfterMessage(outputView::printAmountMessage) { inputView.inputPurchaseAmount() }
        val quantity = lottoGame.getQuantity(purchaseAmount)
        outputView.printLottoQuantity(quantity)
        val lottoNumbers = lottoGame.createRandomLottoNumbers(quantity)
        outputView.printLottoNumbers(lottoNumbers)
        val winningNumber = getInputAfterMessage(outputView::printLottoWinningNumber) { inputView.inputWinningNumber() }
        val bonusNumber = getInputAfterMessage(outputView::printBonusNumber) { inputView.inputBonusNumber(winningNumber) }

        action(purchaseAmount, lottoNumbers, winningNumber, bonusNumber)
    }

    private fun processGame(
        purchaseAmount: Int, lottoNumbers: List<Lotto>, winningNumber: Lotto, bonusNumber: Int
    ): LottoWinningResult {
        val lottoResults = lottoGame.getLottoResults(lottoNumbers, winningNumber, bonusNumber)
        val lottoMatchResult = lottoGame.getLottoMatchResult(lottoResults)
        val rate = lottoGame.calculateRate(lottoMatchResult, purchaseAmount)
        return LottoWinningResult(lottoMatchResult, rate)
    }

    private inline fun <T> getInputAfterMessage(printMessage: () -> Unit, input: () -> T): T {
        printMessage()
        return input()
    }
}