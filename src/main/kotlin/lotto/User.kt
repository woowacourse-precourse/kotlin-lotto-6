package lotto

import lotto.io.UserInterface

class User(
    private val myLottoTickets: List<Lotto>,
    private val amount: Int) {

    fun showMyInform() {
        showLottoCounts()
        for(lotto in myLottoTickets) {
            lotto.showNumbers()
        }
    }

    private fun showLottoCounts() {
        val lottoCounts = amount / 1000
        val ui = UserInterface()
        ui.printLottoCounts(lottoCounts)
    }
}