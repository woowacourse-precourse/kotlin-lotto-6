package lotto.controller

import lotto.model.LottoService
import lotto.view.LottoView

class LottoController {
    private val lottoService = LottoService
    private val lottoView: LottoView by lazy { LottoView() }
    private lateinit var purchasedLottoList: List<List<Int>>
    private lateinit var winningNumber: List<Int>
    private var bonusNumber: Int = NOT_SET

    fun start() {
        buyLotto()
    }

    private fun buyLotto() {
        val money = lottoView.showBuyViewAndReturnMoney()
        purchasedLottoList = lottoService.buyLotto(money)
    }

    companion object {
        private const val NOT_SET = -1
    }
}