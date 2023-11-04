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
    private var userLottoNumber = listOf<Int>()
    private var bonusNumber = 0

    fun playGame(){
        getPurchaseAmount()
        getTicketNumber(purchaseAmount)
        getRandomLottoLists()
        outputView.outputPurchaseCountMessage(ticket)
        outputView.outputRandomLottoList(randomLottoLists)
        val enterWinningNumbers = getEnterWinningNumbers()
        convertStringToList(enterWinningNumbers)
        getBonusNumber()


    }
    private fun getPurchaseAmount(){
        purchaseAmount = inputView.inputPurchaseAmountMessage().toInt()
    }
    private fun getTicketNumber(purchaseAmount: Int) {
        ticket = lottoGameService.calculateLottoPurchaseQuantity(purchaseAmount)
    }
    private fun getRandomLottoLists(){
        randomLottoLists=lottoGameService.lottoNumberGenerator(ticket)
    }
    private fun getEnterWinningNumbers(): String {
        return inputView.inputEnterWinningNumbersMessage()
    }
    private fun convertStringToList(enterWinningNumbers: String){
        userLottoNumber = enterWinningNumbers.split(",").map { it.trim().toInt() }
    }
}