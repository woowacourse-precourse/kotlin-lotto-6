package lotto.domain

import lotto.io.UserInterface
import lotto.model.Lotto
import lotto.model.User
import lotto.util.Const

class MoneyInput(
    private val ui: UserInterface
) {

    fun setUserInform(): User {
        val amount = ui.askPurchaseAmount()
        val lottoTickets = LottoMaker().makeLottoTickets(amount)
        val user = User(lottoTickets, amount)
        showMyLotto(lottoTickets, user.getAmount() / Const.DOLLAR)
        return user
    }

    private fun showMyLotto(lottoTickets: List<Lotto>, lottoCounts: Int) {
        ui.printLottoCounts(lottoCounts)
        for (lotto in lottoTickets) {
            ui.printLotto(lotto.getLottoNumbers())
        }

    }
}