package lotto.ui

import camp.nextstep.edu.missionutils.Console

class LottoView {
    fun askPurchaseTickets(): String {
        println("구입금액을 입력해 주세요.")
        val price = Console.readLine()

        return price
    }

    fun calculateTicketCount(price: Int): Int = price / PRICE_PER_TICKET

    fun showPurchasedTicketCount(ticketCount: Int) {
        printWithNewLine("${ticketCount}개를 구매했습니다.")
    }

    fun askLuckyNumbers(): List<Int> {
        printWithNewLine("당첨 번호를 입력해 주세요.")
        val luckyNumbers = Console.readLine()

        return luckyNumbers.split(DELIMITER_COMMA).map { it.toInt() }.toList()
    }

    fun askBonusNumber(): Int {
        printWithNewLine("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()

        return bonusNumber.toInt()
    }

    fun showWinResult(ranks: List<Int>) {
        println("3개 일치 (5,000원) - ${ranks[RANK_5TH]}개")
        println("4개 일치 (50,000원) - ${ranks[RANK_4TH]}개")
        println("5개 일치 (1,500,000원) - ${ranks[RANK_3RD]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranks[RANK_2ND]}개")
        println("6개 일치 (2,000,000,000원) - ${ranks[RANK_1ST]}개")
    }

    fun showOverviewWinResult() {
        printWithNewLine("당첨 통계")
        println(DIVIDER)
    }

    fun showRateOfProfit(rateOfProfit: Double) {
        print("총 수익률은 ${rateOfProfit}%입니다.")
    }
    
    private fun printWithNewLine(output: String) {
        println(
            """
                
            $output
            """.trimIndent()
        )
    }

    companion object {
        const val DELIMITER_COMMA: String = ","
        const val DIVIDER: String = "---"

        const val PRICE_PER_TICKET: Int = 1_000

        const val RANK_1ST: Int = 1
        const val RANK_2ND: Int = 2
        const val RANK_3RD: Int = 3
        const val RANK_4TH: Int = 4
        const val RANK_5TH: Int = 5
    }
}