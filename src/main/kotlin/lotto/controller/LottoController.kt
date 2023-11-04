package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoService
import lotto.util.OutputUtil.printPurchasedLottoList
import lotto.view.LottoView

class LottoController {
    private val lottoService = LottoService
    private val lottoView: LottoView by lazy { LottoView() }
    private lateinit var purchasedLottoList: List<Lotto>
    private lateinit var winningNumber: Lotto
    private var bonusNumber: Int = NOT_SET

    fun start() {
        buyLotto()
        createWinningNumberAndBonusNumber()
    }

    private fun buyLotto() {
        val money = lottoView.showBuyViewAndReturnMoney()
        purchasedLottoList = lottoService.buyLotto(money)
        printPurchasedLottoList(purchasedLottoList)
    }

    private fun createWinningNumberAndBonusNumber() {
        winningNumber = lottoView.showAndReturnWinningNumber()
        bonusNumber = lottoView.showAndReturnBonusNumber(winningNumber)
    }

    companion object {
        private const val NOT_SET = -1
    }
}