package lotto.domain

import lotto.InputService
import lotto.view.OutputView

class LottoProgram {
    private val inputService = InputService()
    private val outputView = OutputView()
    private val lottoMachine = LottoMachine()
    private lateinit var lottos: Lottos
    private lateinit var winningLotto: WinningLotto
    private lateinit var lottoResult: LottoResult

    fun startProgram() {
        purchaseLottos()
        drawWinningLotto()
        displayResult()
    }

    private fun purchaseLottos() {
        val inputMoney = inputService.getInputMoney()
        lottos = Lottos(lottoMachine.issueLottos(inputMoney))
        outputView.printLottoPurchaseReceipt(lottos)
    }

    private fun drawWinningLotto() {
        val winningNumbers = inputService.getWinningNumbers()
        val bonusNumber = inputService.getBonusNumber(winningNumbers)
        winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)
    }

    private fun displayResult() {
        lottoResult = LottoResult(lottos, winningLotto)
        outputView.printResults(lottoResult)
    }
}