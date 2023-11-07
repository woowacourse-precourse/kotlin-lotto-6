package lotto.view

import lotto.model.Lotto
import lotto.utils.Notice
import org.mockito.internal.matchers.Not

class Output {
    fun startGameNotice() {
        println(Notice.PURCHASE_PAYMENT)
    }

    fun showLottoTickets(generatedAutoLottoTickets: List<Lotto>) {
        println(generatedAutoLottoTickets.size.toString()+Notice.PURCHASED_TICKET_NUMS)
        for (ticket in generatedAutoLottoTickets){
            println(ticket)
        }
    }

    fun getWinningInfoNotice() {
        println(Notice.ENTER_WINNING_INFO)
    }

    fun getBonusInfoNotice() {
        TODO("Not yet implemented")
    }

    fun showResult(generatedAutoLottoTickets: List<Lotto>, winningLottoInfo: Lotto, bonusInfo: Int) {

    }
}