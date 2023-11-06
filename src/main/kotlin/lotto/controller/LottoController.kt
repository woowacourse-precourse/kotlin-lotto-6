package lotto.controller

import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private var money = NOT_INITIALIZED
    private lateinit var lottoNumbers: Lotto
    private var bonusNumber = NOT_INITIALIZED.toInt()

    fun run() {
        purchaseLotto()
    }

    private fun purchaseLotto() {
        outputView.printInputMoney()
        inputView.readInputMoney().also { money -> this.money = money }
        outputView.printInputNumbers()
        inputView.readInputNumbers().also { lotto -> this.lottoNumbers = lotto }
        outputView.printInputBonus()
        inputView.readInputBonus(lottoNumbers).also { bonusNumber -> this.bonusNumber = bonusNumber }
    }

    companion object {
        private const val NOT_INITIALIZED = -1L
    }
}