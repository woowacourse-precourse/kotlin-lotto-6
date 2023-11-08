package lotto.view

import lotto.model.PrizeReceipt
import lotto.model.Rank
import lotto.model.seller.Ticket

class OutputView {

    fun printPaymentAmountInput() = println(Message.EnterPurchaseAmonut)

    fun printLottoTicket(ticket: Ticket) {
        val message = buildString {
            appendLine()
            appendLine(format(Message.Purchased, ticket.lottoCount))
            appendLine(ticket)
        }
        print(message)
    }

    fun printWinningNumbersInput() = println("\n${Message.EnterWinningNumbers}")

    fun printBonusInput() = println("\n${Message.EnterBonusNumber}")

    fun printResult(prizeReceipt: PrizeReceipt) {
        val message = buildString {
            appendLine()
            appendLine(Message.WinningStatsHeader)
            append(getPrizeReport(prizeReceipt))
            append(format(Message.ProfitRateTemplate, prizeReceipt.rate))
        }
        print(message)
    }

    fun printError(message: String?) {
        println("${Message.ErrorToken} $message")
    }

    private fun getPrizeReport(receipt: PrizeReceipt): String = buildString {
        Rank.entries.sortedBy { rank -> rank.prize.value }.forEach { rank ->
            val prizeFormat = format(Message.PrizeTemplate, rank.prize.value)
            append(format(Message.MatchedCountTemplate, rank.matchingCount))
            if (rank == Rank.Second) {
                append(Message.MatchBonus)
            }
            appendLine(format(Message.PrizeCountTemplate, prizeFormat, receipt.getCountByRank(rank)))
        }
    }

    private fun format(message: Message, vararg any: Any): String = message.toString().format(*any)

    private enum class Message(private val message: String) {
        EnterPurchaseAmonut("구입금액을 입력해 주세요."),
        Purchased("%d개를 구매했습니다."),
        EnterWinningNumbers("당첨 번호를 입력해 주세요."),
        EnterBonusNumber("보너스 번호를 입력해 주세요."),
        WinningStatsHeader("당첨 통계\n---"),
        MatchBonus(", 보너스 볼 일치"),
        PrizeTemplate("%,d"),
        PrizeCountTemplate(" (%s원) - %d개"),
        MatchedCountTemplate("%d개 일치"),
        ProfitRateTemplate("총 수익률은 %.1f%%입니다."),
        ErrorToken("[ERROR]");

        override fun toString(): String = message
    }
}