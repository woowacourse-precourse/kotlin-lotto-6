package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

class OutputView {
    companion object {
        const val PURCHASE_COUNT_STRING = "개를 구매했습니다."
        const val WINNING_STATISTICS_STRING = "당첨 통계"
        const val DASH_SEPARATOR = "---"
        const val RATE_OF_RETURN_STRING = "총 수익률은 "
        const val PERCENT_SUFFIX = "%입니다."

        fun printPurchaseCount(numberOfTickets: Int) {
            println("$numberOfTickets$PURCHASE_COUNT_STRING")
        }

        fun printTickets(tickets: List<Lotto>) {
            tickets.forEach { ticket ->
                println(ticket.getNumbers().joinToString(", ", prefix = "[", postfix = "]"))
            }
        }

        fun printPrizeDetails(results: List<LottoRank>, ranks: List<LottoRank>) {
            println(WINNING_STATISTICS_STRING)
            println(DASH_SEPARATOR)

            ranks.forEach { rank ->
                val count = results.count { it == rank }
                println(
                    "${rank.matchCount}개 일치${if (rank.hasBonus) ", 보너스 볼 일치 " else " "}" +
                            "(${rank.prizeMoney}원) - ${count}개"
                )
            }
        }

        fun printRateOfReturn(rateOfReturn: Double) {
            print(RATE_OF_RETURN_STRING + String.format("%.1f", rateOfReturn) + PERCENT_SUFFIX)
        }
    }
}
