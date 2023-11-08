package lotto.controller

import lotto.model.Lottoes
import lotto.model.WinningRank
import lotto.view.InputView
import lotto.view.OutputView

class GameController {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = InputValidator()
    private lateinit var lottoes: Lottoes

    fun start() {
        buyLottoes()
        showLottoInformation()

        val inputNumbers = insertLottoNumbers()
        insertBonusNumber(inputNumbers)

        val winningResult = lottoes.calculateLottoesResult()
        showLottoResult(winningResult)
    }

    private fun buyLottoes() {
        var isValid: Boolean
        do {
            outputView.purchasePrompt()
            val payment = inputView.purchaseAmount()
            isValid = validator.validatePurchaseAmount(payment)
            lottoes = Lottoes(payment)
        } while (!isValid)
    }

    private fun showLottoInformation() {
        outputView.lottoNumbersPrompt(lottoes.lottoTicketCount)
        outputView.lottoNumbers(lottoes.lottoes)
    }

    private fun insertLottoNumbers(): List<Int> {
        var isValid: Boolean
        var inputNumbers: List<Int>
        do {
            outputView.inputLottoNumbersPrompt()
            inputNumbers = inputView.lottoNumbers()
            isValid = validator.validateLottoNumbers(inputNumbers)
            lottoes.userNumbers = inputNumbers.toSet()
        } while (!isValid)
        return inputNumbers
    }

    private fun insertBonusNumber(inputNumbers: List<Int>) {
        var isValid: Boolean
        do {
            outputView.inputBonusNumberPrompt()
            val bonusNumber = inputView.bonusLottoNumber()
            isValid = validator.validateBonusNumber(bonusNumber, inputNumbers)
            lottoes.bonusNumber = bonusNumber
        } while (!isValid)
    }


    private fun showLottoResult(winningResult: Map<WinningRank, Int>) {
        outputView.winningResultPrompt()
        outputView.winningResult(winningResult)
        outputView.totalProfitRate(lottoes.getProfitRate())
    }
}