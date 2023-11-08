package lotto.domain

import lotto.InputService
import lotto.view.OutputView

class LottoProgram {
    private val inputService = InputService()
    private val outputView = OutputView()
    private lateinit var lottoMachine: LottoMachine
    private lateinit var lottos: List<Lotto>
    private lateinit var winningLotto: WinningLotto
    private lateinit var lottoResult: LottoResult

    fun run() {
        purchaseLottos()
        drawWinningLotto()
        displayResult()
    }

    private fun purchaseLottos() {
        val inputMoney = inputService.getInputMoney()
        lottoMachine = LottoMachine(inputMoney)
        lottos = lottoMachine.issueLottos()
        outputView.printLottosReceipt(lottos)
    }

    private fun drawWinningLotto() {
        val winningNumbers = inputService.getWinningNumbers()
        val bonusNumber = inputService.getBonusNumber(winningNumbers)
        winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)
    }

    private fun displayResult() {
        lottoResult = lottoMachine.calculateResult(lottos, winningLotto)
        val rateOfReturn = lottoMachine.getRateOfReturn(lottoResult)
        outputView.printWinningStatistics(lottoResult)
        outputView.printRateOfReturn(rateOfReturn)
    }
}