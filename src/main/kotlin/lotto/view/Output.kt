package lotto.view

import lotto.model.Lotto
import lotto.utils.Notice

class Output {
    fun startGameNotice() {
        println(Notice.PURCHASE_PAYMENT)
    }

    fun showLottoTickets(generatedAutoLottoTickets: List<Lotto>) {
        println(generatedAutoLottoTickets.size.toString()+"개를 구매했습니다.")
        for (ticket in generatedAutoLottoTickets){
            println(ticket)
        }
    }

    fun getWinningInfoNotice() {
        TODO("Not yet implemented")
    }

    fun getBonusInfoNotice() {
        TODO("Not yet implemented")
    }

    fun showResult(generatedAutoLottoTickets: List<Lotto>, winningLottoInfo: Lotto, bonusInfo: Int) {

    }
}