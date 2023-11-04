package lotto

import java.text.DecimalFormat

object Printer {
    fun printEmptyLine() {
        println()
    }

    fun print(message: Message) {
        println(message)
    }

    fun print(purchase: Purchase) {
        val lottos = purchase.lottos
        val purchasedMessage = Message.Purchased.toString()
        printEmptyLine()
        println(purchasedMessage.format(lottos.size))
        lottos.forEach { println(it) }
        printEmptyLine()
    }

    fun print(results: List<WinningResult>, profitPercentage: Double) {
        print(Message.WinningResultHeader)
        val winningResultEnums = WinningResult.values()
        winningResultEnums.forEach { enum ->
            if (enum == WinningResult.None) {
                return@forEach
            }
            val count = results.count { it == enum }
            enum.print(count)
        }
        println(Message.ProfitPercentage.format(profitPercentage))
    }

    private fun WinningResult.print(count: Int) {
        val bonusText = if (this == WinningResult.FiveAndBonus) {
            Message.BonusMatch.toString()
        } else ""
        val moneyText = moneyWon.toMoneyFormat()
        println(Message.WinningItemResult.format(matchCount, bonusText, moneyText, count))
    }

    private fun Long.toMoneyFormat(): String {
        return DecimalFormat("#,###").format(this)
    }

    fun error(message: Message) {
        error(message.toString())
    }

    fun error(message: String) {
        println(Message.ErrorPrefix.toString() + message)
    }
}
