package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoCount
import lotto.util.PURCHASE_NUMBER_TEXT
import lotto.util.PURCHASE_PRICE_TEXT

object LottoPurchaseView {
    fun printLottoPurchase() {
        println(PURCHASE_PRICE_TEXT)
    }

    fun inputLottoPurchase(): String {
        return Console.readLine().trim()
    }

    fun outputPurchaseCount(amount: Int): Int {
        val count = LottoCount(amount).calculate()
        println()
        println("$count$PURCHASE_NUMBER_TEXT")
        return count
    }
}