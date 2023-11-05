package lotto.controller

import lotto.Constants.Companion.ERROR_EMPTY_WINNING_NUMBER_MESSAGE
import lotto.LottoGameService
import lotto.model.Bonus
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import lotto.Validator
import java.lang.NumberFormatException

class LottoGameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGameService = LottoGameService()
    private val validator = Validator()


    fun playGame() {
        val purchaseAmount = getPurPurchaseAmount()
        val ticket = getTicketNumber(purchaseAmount)
        val randomLottoLists = getRandomLottoLists(ticket)
        outputView.outputPurchaseCountMessage(ticket)
        outputView.outputRandomLottoList(randomLottoLists)
        val lotto = getWinningNumbers()
        val bonus = getBonusNumber(lotto)
        lottoGameService.calculateWinningStatistics(lotto, bonus, randomLottoLists, ticket)
        outputView.outputWinningStatisticsMessage()
        val profit = lottoGameService.calculateProfitPercentage(purchaseAmount.toDouble())
        outputView.outputProfitPercentageMessage(profit)
    }

    private fun getPurPurchaseAmount(): Int {
        return try {
            val purchaseAmount = inputView.purchaseAmountMessage()
            validator.isUserPurchaseAmountCheck(purchaseAmount)
            return purchaseAmount.toInt()
        } catch (error: IllegalArgumentException) {
            getPurPurchaseAmount()
        }
    }

    private fun getTicketNumber(purchaseAmount: Int): Int {
        return lottoGameService.calculateLottoPurchaseQuantity(purchaseAmount)
    }

    private fun getRandomLottoLists(ticket: Int): MutableMap<Int, List<Int>> {
        return lottoGameService.lottoNumberGenerator(ticket)
    }

    private fun getWinningNumbers(): List<Int> {
        return try {
            val winningNumber = lottoGameService.convertStringToList(inputView.enterWinningNumbersMessage())
            Lotto(winningNumber).getNumber
        } catch (error: NumberFormatException) {
            println(ERROR_EMPTY_WINNING_NUMBER_MESSAGE)
            getWinningNumbers()
        }catch (error: IllegalArgumentException) {
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