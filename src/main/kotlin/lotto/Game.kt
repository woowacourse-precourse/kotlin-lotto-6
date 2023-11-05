package lotto

import lotto.domain.Draw
import lotto.domain.Purchase
import lotto.domain.Sale
import lotto.presentation.DrawScreen
import lotto.presentation.PurchaseScreen
import lotto.presentation.SaleScreen

class Game {
    private val purchaseScreen = PurchaseScreen()
    private val purchase = Purchase()
    private val saleScreen = SaleScreen()
    private val sale = Sale()
    private val drawScreen = DrawScreen()
    private val draw = Draw()

    fun paying(): Int {
        while (true) {
            try {
                purchaseScreen.outputRequestAmount()
                val amount = purchaseScreen.inputAmount()
                return purchase.payMoney(amount)
            } catch (e: IllegalArgumentException) {
                println("$ERROR_MESSAGE_SETTING${e.message}\n")
            }
        }
    }

    fun calculating(amount: Int): Int {
        return purchase.calculateLottoTicketCount(amount)
    }

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
                println("$ERROR_MESSAGE_SETTING${e.message}\n")
            }
        }
    }

    companion object {
        const val ERROR_MESSAGE_SETTING = "[ERROR] "
    }
}