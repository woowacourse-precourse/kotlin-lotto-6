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
        outputView.purchasePrompt()
        val payment = inputView.purchaseAmount()

        validator.validatePurchaseAmount(payment)
        lottoes = RealLottoes(payment)

        outputView.lottoNumbersPrompt(lottoes.lottoTicketCount)
        outputView.lottoNumbers(lottoes.lottoes)

        outputView.inputLottoNumbersPrompt()
        val inputNumbers = inputView.lottoNumbers()
        validator.validateLottoNumbers(inputNumbers)
        lottoes.userNumbers = inputNumbers.toSet()

        outputView.inputBonusNumberPrompt()
        val bonusNumber = inputView.bonusLottoNumber()
        validator.validateNumber(bonusNumber)
        lottoes.bonusNumber = bonusNumber

        val winningResult = lottoes.calculateLottoesResult()
        outputView.winningResultPrompt()
        outputView.winningResult(winningResult)
        outputView.totalProfitRate(lottoes.getProfitRate())
    }
}