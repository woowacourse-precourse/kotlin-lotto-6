package lotto.controller

import lotto.LottoGameService
import lotto.model.Bonus
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import lotto.Validator

class LottoGameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGameService = LottoGameService()
    private val validator = Validator()
    private var ticket = 0
    private var randomLottoLists = mutableMapOf<Int,List<Int>>()
    private var purchaseAmount = 0

    fun playGame(){
        getPurchaseAmount()
        getTicketNumber(purchaseAmount)
        getRandomLottoLists()
        outputView.outputPurchaseCountMessage(ticket)
        outputView.outputRandomLottoList(randomLottoLists)
        val enterWinningNumbers = getEnterWinningNumbers()
        val lotto = Lotto(convertStringToList(enterWinningNumbers)).getNumber
        val bonus = Bonus(getBonusNumber()).getBonusNumber
        validator.checkForDuplicates(lotto,bonus)
        lottoGameService.calculateWinningStatistics(lotto,bonus)
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
    private fun convertStringToList(enterWinningNumbers: String): List<Int> {
         return enterWinningNumbers.split(",").map { it.trim().toInt() }
    }
    private fun getBonusNumber(): Int {
        return inputView.inputEnterBonusNumbersMessage().toInt()
    }

}