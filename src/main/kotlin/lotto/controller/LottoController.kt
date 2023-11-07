package lotto.controller

import lotto.model.Lotto
import lotto.view.LottoView

class LottoController {
    private val lottoView = LottoView()
    private var money = NOT_INITIALIZED
    private lateinit var lottoNumbers: Lotto
    private var bonusNumber = NOT_INITIALIZED.toInt()

    fun run() {
        purchaseLotto()
        generateLotto()
    }

    private fun purchaseLotto() {
        lottoView.readInputMoney().also { money -> this.money = money }
        lottoView.readInputNumbers().also { lotto -> this.lottoNumbers = lotto }
        lottoView.readInputBonus(lottoNumbers).also { bonusNumber -> this.bonusNumber = bonusNumber }
    }

    private fun generateLotto() {
//        lottoView.printLottoCount()

    }

    companion object {
        private const val NOT_INITIALIZED = -1L
    }
}