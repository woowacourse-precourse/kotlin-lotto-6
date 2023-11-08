package lotto

import lotto.io.UserInterface

class MoneyInput(
    private val ui: UserInterface
) {

    fun setUserInform(): User {
        val amount = ui.askPurchaseAmount()
        val lottoTickets = LottoMaker().makeLottoTickets(amount)
        val user = User(lottoTickets, amount)
        showMyLotto(lottoTickets, user.getAmount() / 1000)
        return user
    }

    private fun showMyLotto(lottoTickets: List<Lotto>, lottoCounts: Int) {
        ui.printLottoCounts(lottoCounts)
        for (lotto in lottoTickets) {
            ui.printLotto(lotto.getLottoNumbers())
        }

    }


}