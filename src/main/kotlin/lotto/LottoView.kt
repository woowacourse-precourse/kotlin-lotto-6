package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Strings

//사용자로부터 입력을 받고, 결과를 출력하는 역할을 합니다.
class LottoView {

    fun getPurchaseAmountFromUser(): Int {
        while (true) {
            println(Strings.VIEW_PURCHASE_AMOUNT)
            val input = Console.readLine()
            try {
                return Exception.purchaseAmountEntryException(input) ?: continue
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun displayGeneratedLottoTickets(numOfTickets: Int, lottoTickets: List<Lotto>) {
        println("\n$numOfTickets"+Strings.VIEW_PURCHASE)
        lottoTickets.forEach { lottoTicket ->
            println(lottoTicket.numbers.sorted())
        }
    }

    fun getWinningNumbersFromUser(): List<Int> {
        while (true) {
            try {
                println("\n"+Strings.VIEW_WINNING_NUMBER)
                val input = Console.readLine()
                return Exception.enterWinningNumberException(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumberFromUser(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("\n"+Strings.VIEW_BONUS_NUMBER)
                val input = Console.readLine()
                return Exception.enterBonusNumberException(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun displayWinningStatistics(){
        println("\n"+Strings.VIEW_WINNING_STATISTICS)
        println("---")
    }

}