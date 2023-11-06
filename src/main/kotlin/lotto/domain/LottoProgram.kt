package lotto.domain

import lotto.InputService
import lotto.view.OutputView

class LottoProgram {
    private val inputService = InputService()
    private val outputView = OutputView()
    private val lottoMachine = LottoMachine()
    private lateinit var lottos: List<Lotto>
    private lateinit var winningLotto: WinningLotto
    private lateinit var resultCalculator: ResultCalculator
    private lateinit var lottoResult: LottoResult
    private var inputMoney = 0

    fun startProgram() {
        purchaseLottos()
        drawWinningLotto()
        displayResult()
    }

    private fun purchaseLottos() {
        inputMoney = inputService.getInputMoney()
        lottos = lottoMachine.issueLottos(inputMoney)
        outputView.printLottoPurchaseReceipt(lottos)
    }

    private fun drawWinningLotto() {
        val winningNumbers = inputService.getWinningNumbers()
        val bonusNumber = inputService.getBonusNumber(winningNumbers)
        winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)
    }

    private fun displayResult() {
        resultCalculator = ResultCalculator(lottos, winningLotto)
        lottoResult = resultCalculator.calculateResult()
        outputView.printWinningStatistics(lottoResult)
        outputView.printRateOfReturn(lottoResult.getRateOfReturn(inputMoney))
    }
}