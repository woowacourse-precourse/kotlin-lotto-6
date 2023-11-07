package lotto.view

import lotto.model.Lotto
import lotto.utils.Notice

class Output {
    fun startGameNotice() {
        println(Notice.PURCHASE_PAYMENT)
    }

    fun showLottoTickets(generatedAutoLottoTickets: List<Lotto>) {
        TODO("Not yet implemented")
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