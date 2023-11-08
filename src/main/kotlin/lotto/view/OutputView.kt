package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

class OutputView {
    companion object {
        private const val PURCHASE_COUNT_STRING = "개를 구매했습니다."
        private const val WINNING_STATISTICS_STRING = "당첨 통계"
        private const val DASH_SEPARATOR = "---"
        private const val RATE_OF_RETURN_STRING = "총 수익률은 "
        private const val PERCENT_SUFFIX = "%입니다."

        fun purchaseCount(numberOfTickets: Int) {
            println("$numberOfTickets$PURCHASE_COUNT_STRING")
        }

        fun ticketDetails(tickets: List<Lotto>) {
            tickets.forEach { ticket ->
                println(ticket.getNumbers().joinToString(", ", prefix = "[", postfix = "]"))
            }
        }

        fun prizeDetails(results: List<LottoRank>, ranks: List<LottoRank>) {
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

        fun rateOfReturn(rateOfReturn: Double) {
            print(RATE_OF_RETURN_STRING + String.format("%.1f", rateOfReturn) + PERCENT_SUFFIX)
        }
    }
}
