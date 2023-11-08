package lotto.domain

import lotto.ui.InputManager
import lotto.ui.OutputManager

class LottoProgram {
    private val inputManager = InputManager()
    private val outputManager = OutputManager()
    private lateinit var lottoMachine: LottoMachine
    private lateinit var lottos: List<Lotto>
    private lateinit var winningLotto: WinningLotto
    private lateinit var lottoResult: LottoResult

    fun run() {
        purchaseLottos()
        drawWinningLotto()
        displayOutcome()
    }

    private fun purchaseLottos() {
        val inputMoney = inputManager.getInputMoney()
        lottoMachine = LottoMachine(inputMoney)
        lottos = lottoMachine.issueLottos()
        outputManager.printLottosReceipt(lottos)
    }

    private fun drawWinningLotto() {
        val winningNumbers = inputManager.getWinningNumbers()
        val bonusNumber = inputManager.getBonusNumber(winningNumbers)
        winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)
    }

    private fun displayOutcome() {
        lottoResult = lottoMachine.calculateResult(lottos, winningLotto)
        val rateOfReturn = lottoMachine.getRateOfReturn(lottoResult)
        outputManager.printWinningStatistics(lottoResult)
        outputManager.printRateOfReturn(rateOfReturn)
    }
}