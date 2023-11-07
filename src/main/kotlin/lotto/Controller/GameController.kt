package lotto.Controller

import lotto.Model.LottoTicket
import lotto.Model.Result
import lotto.View.*
import java.util.*

class GameController {
    fun run() {
        val purchaseAmount = readPurchaseAmount()

    }

    private fun readPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmountString = Input.readPurchaseAmount()
                val purchaseAmount = purchaseAmountString.toInt()
                if (purchaseAmount % 1000 == 0) {
                    return purchaseAmount
                }
                Error.notValidPurchaseAmount()
            } catch (e: NumberFormatException) {
                Error.NAN()
            }
        }
    }

}
