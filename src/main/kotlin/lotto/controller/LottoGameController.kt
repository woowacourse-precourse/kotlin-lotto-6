package lotto.controller

import lotto.domain.LottoGame
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoGame: LottoGame,
) {

    fun run() {
        outputView.printAmountMessage()
        val purchaseAmount = inputView.inputPurchaseAmount()

        playLottoGame(purchaseAmount = purchaseAmount) { lottoNumbers, winningNumber, bonusNumber ->
            val lottoResults = lottoGame.getLottoResults(
                lottoNumbers = lottoNumbers,
                winningNumber = winningNumber,
                bonusNumber = bonusNumber,
            )
            val lottoMatchResult = lottoGame.getLottoMatchResult(lottoResults = lottoResults)
            val rate = lottoGame.calculateRate(lottoMatchResult = lottoMatchResult, purchaseAmount = purchaseAmount)
            outputView.printLottoWinningResults(lottoMatchResult = lottoMatchResult, rate = rate)
        }
    }

    private inline fun playLottoGame(purchaseAmount: Int, action: (List<Lotto>, Lotto, Int) -> Unit) {
        val quantity = lottoGame.getQuantity(purchaseAmount = purchaseAmount)
        outputView.printLottoQuantity(quantity = quantity)

        val lottoNumbers = lottoGame.createRandomLottoNumbers(quantity = quantity)
        outputView.printLottoNumbers(lottoNumbers = lottoNumbers)

        outputView.printLottoWinningNumber()
        val winningNumber = inputView.inputWinningNumber()

        outputView.printBonusNumber()
        val bonusNumber = inputView.inputBonusNumber(winningNumber = winningNumber)
    private fun processGame(
        purchaseAmount: Int, lottoNumbers: List<Lotto>, winningNumber: Lotto, bonusNumber: Int
    ): LottoWinningResult {
        val lottoResults = lottoGame.getLottoResults(lottoNumbers, winningNumber, bonusNumber)
        val lottoMatchResult = lottoGame.getLottoMatchResult(lottoResults)
        val rate = lottoGame.calculateRate(lottoMatchResult, purchaseAmount)
        return LottoWinningResult(lottoMatchResult, rate)
    }

        action(lottoNumbers, winningNumber, bonusNumber)
    }
}