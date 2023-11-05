package lotto.controller

import lotto.Constants.Companion.ERROR_INVALID_LOTTO_AMOUNT_EXCEPTION
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
        val purchaseAmount= getPurchaseAmount()
        getTicketNumber(purchaseAmount)
        getRandomLottoLists()
        outputView.outputPurchaseCountMessage(ticket)
        outputView.outputRandomLottoList(randomLottoLists)
        val lotto = Lotto(getWinningNumbers()).getNumber
        val bonus =  Bonus(getBonusNumber(lotto)).getBonusNumber
        lottoGameService.calculateWinningStatistics(lotto,bonus,randomLottoLists,ticket)
        outputView.outputWinningStatisticsMessage()
        val profit = lottoGameService.calculateProfitPercentage(purchaseAmount.toDouble())
        outputView.outputProfitPercentageMessage(profit)
    }
    private fun getPurchaseAmount(): Int {
        return inputView.inputPurchaseAmountMessage().toInt()
    }

    private fun getTicketNumber(purchaseAmount: Int) {
        ticket = lottoGameService.calculateLottoPurchaseQuantity(purchaseAmount)
    }
    private fun getRandomLottoLists(){
        randomLottoLists=lottoGameService.lottoNumberGenerator(ticket)
    }
    private fun getWinningNumbers(): List<Int> {
        return inputView.inputEnterWinningNumbersMessage()
    }
    private fun getBonusNumber(lotto: List<Int>): Int {
        return inputView.inputEnterBonusNumbersMessage(lotto).toInt()
    }

}