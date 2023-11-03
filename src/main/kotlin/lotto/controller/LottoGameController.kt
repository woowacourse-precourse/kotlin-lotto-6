package lotto.controller

import lotto.LottoGameService
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGameService = LottoGameService()
    private var ticket = 0
    private var randomLottoLists = mutableMapOf<Int,List<Int>>()
    private var purchaseAmount = 0

    fun playGame(){
        getPurchaseAmount()

    }
    private fun getPurchaseAmount(){
        purchaseAmount = inputView.inputPurchaseAmountMessage().toInt()
    }
}