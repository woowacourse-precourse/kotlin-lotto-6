package lotto

import camp.nextstep.edu.missionutils.Console

//사용자로부터 입력을 받고, 결과를 출력하는 역할을 합니다.
class LottoView {

    fun getPurchaseAmountFromUser(): Int {
        while (true) {
            println("구입 금액을 입력해 주세요.")
            val input = Console.readLine()
            return Exception.purchaseAmountEntryException(input) ?: continue
        }
    }

    fun displayGeneratedLottoTickets(numOfTickets: Int, lottoTickets: List<Lotto>) {
        println("$numOfTickets 개를 구매했습니다.")
        lottoTickets.forEach { lottoTicket ->
            println(lottoTicket.numbers.sorted())
        }
    }

}