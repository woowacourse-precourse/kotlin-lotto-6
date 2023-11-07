package lotto.View

import lotto.Lotto
import lotto.Model.Prize

object Output {

    fun printLotto(lottoTickets: List<Lotto>) {
        val purchaseAmount = lottoTickets.size
        println("${purchaseAmount}개를 구매했습니다.")

        for (lottoTicket in lottoTickets) {
            val numbers = lottoTicket.getNumbers()
            println(numbers)
        }
    }


}
