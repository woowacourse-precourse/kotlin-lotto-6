package lotto

import lotto.domain.Purchase
import lotto.presentation.PurchaseScreen

fun main() {
    val amount = paying()
    val lottoTicketCount = Purchase().calculateLottoTicketCount(amount)
    println(lottoTicketCount)
}

fun paying(): Int {
    val purchaseScreen = PurchaseScreen()
    val purchase = Purchase()

    while (true) {
        try {
            purchaseScreen.outputRequestAmount()
            val amount = purchaseScreen.inputAmount()
            return purchase.payMoney(amount)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}\n")
        }
    }
}