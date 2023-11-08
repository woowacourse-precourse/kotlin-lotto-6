package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoService
import lotto.model.LottoService.getEarningRate
import lotto.model.LottoService.getWinningMap
import lotto.model.Winner
import lotto.view.LottoView
import java.util.*

class LottoController {
    private val lottoService = LottoService
    private val lottoView: LottoView by lazy { LottoView() }
    private lateinit var purchasedLottoList: List<Lotto>
    private lateinit var winningNumber: Lotto
    private lateinit var winningMap: EnumMap<Winner, Int>
    private var money: Int = NOT_SET
    private var bonusNumber: Int = NOT_SET

    fun start() {
        buyLotto()
        createWinningNumberAndBonusNumber()
        getResult()
    }

    private fun buyLotto() {
        money = lottoView.showBuyViewAndReturnMoney()
        purchasedLottoList = lottoService.buyLotto(money)
        lottoView.showPurchasedLottoList(purchasedLottoList)
    }

    private fun createWinningNumberAndBonusNumber() {
        winningNumber = lottoView.showAndReturnWinningNumber()
        bonusNumber = lottoView.showAndReturnBonusNumber(winningNumber)
    }

    private fun getResult() {
        winningMap = getWinningMap(purchasedLottoList, winningNumber, bonusNumber)
        lottoView.showWinningDetails(winningMap, getEarningRate(winningMap, money))
    }

    companion object {
        private const val NOT_SET = -1
    }
}