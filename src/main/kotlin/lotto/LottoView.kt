package lotto

import camp.nextstep.edu.missionutils.Console

//사용자로부터 입력을 받고, 결과를 출력하는 역할을 합니다.
class LottoView {

    fun getPurchaseAmountFromUser(): Int {
        while (true) {
            println("구입 금액을 입력해 주세요.")
            val input = Console.readLine()
            try {
                return Exception.purchaseAmountEntryException(input) ?: continue
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun displayGeneratedLottoTickets(numOfTickets: Int, lottoTickets: List<Lotto>) {
        println("$numOfTickets 개를 구매했습니다.")
        lottoTickets.forEach { lottoTicket ->
            println(lottoTicket.numbers.sorted())
        }
    }

    fun getWinningNumbersFromUser(): List<Int> {
        while (true) {
            try {
                println("당첨 번호를 입력해 주세요. (1~45까지의 숫자 6개, 쉼표로 구분)")
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
                println("보너스 번호를 입력해 주세요. (1~45까지의 숫자)")
                val input = Console.readLine()
                return Exception.enterBonusNumberException(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}