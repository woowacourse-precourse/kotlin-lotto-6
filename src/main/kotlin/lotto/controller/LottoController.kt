package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoService
import lotto.view.LottoView

class LottoController {
    private val lottoService = LottoService
    private val lottoView: LottoView by lazy { LottoView() }
    private lateinit var purchasedLottoList: List<Lotto>
    private lateinit var winningNumber: Lotto
    private var money: Int = NOT_SET
    private var bonusNumber: Int = NOT_SET

    fun start() {
        buyLotto()
        createWinningNumberAndBonusNumber()
    }

    private fun buyLotto() {
        money = lottoView.showBuyViewAndReturnMoney()
        purchasedLottoList = lottoService.buyLotto(money)
        lottoView.showPurchasedLottoList(purchasedLottoList)
    }

    private fun createWinningNumberAndBonusNumber() {
        with(lottoView) {
            winningNumber = lottoView.showAndReturnWinningNumber()
            bonusNumber = lottoView.showAndReturnBonusNumber(winningNumber)
        }
    }

    companion object {
        private const val NOT_SET = -1
    }
}