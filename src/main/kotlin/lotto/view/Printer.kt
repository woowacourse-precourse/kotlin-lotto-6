package lotto.view

import lotto.model.Message
import lotto.model.Purchase
import lotto.model.Winning
import lotto.model.WinningStatics
import java.text.DecimalFormat

object Printer {
    fun printEmptyLine() {
        println()
    }

    fun print(message: Message) {
        println(message)
    }

    fun print(purchase: Purchase) {
        val purchasedMessage = Message.Purchased
        printEmptyLine()
        println(purchasedMessage.format(purchase.lottoCount))
        println(purchase)
        printEmptyLine()
    }

    fun print(statics: WinningStatics) {
        print(Message.WinningResultHeader)
        val profitPercentage = statics.profitPercentage
        val winnings = Winning.entries.toTypedArray()
        winnings.forEach { winning ->
            if (winning == Winning.None) {
                return@forEach
            }
            val count = statics.countOf(winning)
            winning.print(count)
        }
        println(Message.ProfitPercentage.format(profitPercentage))
    }

    private fun Winning.print(count: Int) {
        val bonusText = if (this == Winning.FiveAndBonus) {
            Message.BonusMatch.toString()
        } else ""
        val moneyText = priceWon.toMoneyFormat()
        println(Message.WinningItemResult.format(matchCount, bonusText, moneyText, count))
    }

    private fun Long.toMoneyFormat(): String {
        return DecimalFormat("#,###").format(this)
    }

    fun error(message: String) {
        println(Message.ErrorPrefix.toString() + message)
    }
}
