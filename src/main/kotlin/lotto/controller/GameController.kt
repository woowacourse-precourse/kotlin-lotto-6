package lotto.controller

import lotto.model.RealLottoes
import lotto.view.InputView
import lotto.view.OutputView

class GameController {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = InputValidator()
    private lateinit var lottoes: RealLottoes

    fun start() {
        var isValid: Boolean
        var inputNumbers: List<Int>
        do {
            outputView.purchasePrompt()
            val payment = inputView.purchaseAmount()
            isValid = validator.validatePurchaseAmount(payment)
            lottoes = RealLottoes(payment)
        } while (!isValid)

        outputView.lottoNumbersPrompt(lottoes.lottoTicketCount)
        outputView.lottoNumbers(lottoes.lottoes)

        do {
            outputView.inputLottoNumbersPrompt()
            inputNumbers = inputView.lottoNumbers()
            isValid = validator.validateLottoNumbers(inputNumbers)
            lottoes.userNumbers = inputNumbers.toSet()
        } while (!isValid)

        do {
            outputView.inputBonusNumberPrompt()
            val bonusNumber = inputView.bonusLottoNumber()
            isValid = validator.validateBonusNumber(bonusNumber, inputNumbers)
            lottoes.bonusNumber = bonusNumber
        } while (!isValid)

        val winningResult = lottoes.calculateLottoesResult()
        outputView.winningResultPrompt()
        outputView.winningResult(winningResult)
        outputView.totalProfitRate(lottoes.getProfitRate())
    }
}