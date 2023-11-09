package lotto

import lotto.domain.Draw
import lotto.domain.Purchase
import lotto.domain.Result
import lotto.domain.Sale
import lotto.domain.util.MathHelper
import lotto.presentation.*

class Game {
    private val purchaseScreen = PurchaseScreen()
    private val purchase = Purchase()
    private val saleScreen = SaleScreen()
    private val sale = Sale()
    private val drawScreen = DrawScreen()
    private val draw = Draw()
    private val resultScreen = ResultScreen()
    private val result = Result()
    private val mathHelper = MathHelper()
    private val errorScreen = ErrorScreen()

    fun paying(): Int {
        while (true) {
            try {
                purchaseScreen.outputRequestAmount()
                val amount = purchaseScreen.inputAmount()
                return purchase.payMoney(amount)
            } catch (e: IllegalArgumentException) {
                errorScreen.outputErrorMessage(e)
            }
        }
    }

    fun calculating(amount: Int): Int = purchase.calculateLottoTicketCount(amount)

    fun buying(lottoTicketCount: Int): List<List<Int>> {
        saleScreen.outputTicketCount(lottoTicketCount)
        val lottoTickets = mutableListOf<List<Int>>()
        repeat(lottoTicketCount) {
            val numbers = sale.generateRandomNumber()
            val lottoTicket = sale.createLottoTicket(numbers)
            lottoTickets.add(lottoTicket)
        }
        saleScreen.outputTickets(lottoTickets)
        return lottoTickets.toList()
    }

    fun drawing(): List<Int> {
        while (true) {
            try {
                drawScreen.outputRequestDrawNumber()
                val drawNumber = drawScreen.inputDrawNumber()
                return draw.validateDrawNumber(drawNumber)
            } catch (e: IllegalArgumentException) {
                errorScreen.outputErrorMessage(e)
            }
        }
    }

    fun bonusDrawing(drawNumbers: List<Int>): Int {
        while (true) {
            try {
                drawScreen.outputRequestBonusNumber()
                val bonusNumber = drawScreen.inputBonusNumber()
                return draw.validateBonusNumber(bonusNumber, drawNumbers)
            } catch (e: IllegalArgumentException) {
                errorScreen.outputErrorMessage(e)
            }
        }
    }

    fun winning(lottoTickets: List<List<Int>>, drawNumbers: List<Int>, bonusNumber: Int) {
        resultScreen.outputResultMessage()
        val countEachPrize = result.checkTickets(lottoTickets, drawNumbers, bonusNumber)
        val totalPrize = result.calculatePrize(countEachPrize)
        val winRate = mathHelper.calculateWinRate(totalPrize, countEachPrize.values.sum())
        val winRateFormat = mathHelper.roundToFirstDecimalPlace(winRate)
        resultScreen.outputWinningResult(countEachPrize)
        resultScreen.outputWinningRate(winRateFormat)
    }
}