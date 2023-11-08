package lotto.controller

import lotto.Constants.ERROR_EMPTY_WINNING_NUMBER_MESSAGE
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

    fun playGame() {
        val purchaseAmount = getPurchasedAmount()
        val ticket = calculateTicketCount(purchaseAmount)
        val randomLottoLists = generateRandomLottoLists(ticket)
        outputView.ticketCountMessage(ticket)
        outputView.randomLottoLists(randomLottoLists)
        val lotto = getWinningNumbers()
        val bonus = getBonusNumber(lotto)
        lottoGameService.calculateWinningStatistics(lotto, bonus, randomLottoLists, ticket)
        outputView.winningStatisticsMessage()
        val profit = lottoGameService.calculateProfitPercentage(purchaseAmount.toDouble())
        outputView.profitPercentageMessage(profit)
    }

    private fun getPurchasedAmount(): Int {
        return try {
            val purchaseAmount = inputView.purchaseAmountMessage()
            validator.isUserPurchaseAmountCheck(purchaseAmount)
            purchaseAmount.toInt()
        } catch (error: IllegalArgumentException) {
            getPurchasedAmount()
        }
    }

    private fun calculateTicketCount(purchaseAmount: Int): Int {
        return lottoGameService.calculateLottoPurchaseQuantity(purchaseAmount)
    }

    private fun generateRandomLottoLists(ticket: Int): MutableMap<Int, List<Int>> {
        return lottoGameService.lottoNumberGenerator(ticket)
    }

    private fun getWinningNumbers(): List<Int> {
        return try {
            val winningNumbers = inputView.enterWinningNumbersMessage()
            val winningNumber = lottoGameService.convertStringToList(winningNumbers)
            Lotto(winningNumber).getNumbers
        } catch (error: NumberFormatException) {
            println(ERROR_EMPTY_WINNING_NUMBER_MESSAGE)
            getWinningNumbers()
        } catch (error: IllegalArgumentException) {
            getWinningNumbers()
        }
    }

    private fun getBonusNumber(lotto: List<Int>): String {
        return try {
            val bonusNumber = inputView.enterBonusNumbersMessage()
            Bonus(lotto, bonusNumber).getBonusNumber
        } catch (error: IllegalArgumentException) {
            getBonusNumber(lotto)
        }
    }
}
