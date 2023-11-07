package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoManager
import lotto.view.LottoView

class LottoController {
    private val lottoView = LottoView()
    private val lottoManager = LottoManager()
    private var lottoCount = NOT_INITIALIZED.toLong()
    private val generatedLottoList = mutableListOf<Lotto>()
    private lateinit var lottoNumbers: Lotto
    private var bonusNumber = NOT_INITIALIZED

    fun run() {
        purchaseLotto()
        inputWinningLotto()
    }

    private fun purchaseLotto() {
        lottoView.readInputMoney().also { money -> this.lottoCount = lottoManager.getMoneyToCount(money) }
        lottoView.printLottoCount(lottoCount)
        for (i in 1..lottoCount) generatedLottoList.add(lottoManager.generateLotto())
        lottoView.printGeneratedLotto(generatedLottoList)
    }

    private fun inputWinningLotto() {
        lottoView.readInputNumbers().also { lotto -> this.lottoNumbers = lotto }
        lottoView.readInputBonus(lottoNumbers).also { bonusNumber -> this.bonusNumber = bonusNumber }
    }

    companion object {
        private const val NOT_INITIALIZED = -1
    }
}