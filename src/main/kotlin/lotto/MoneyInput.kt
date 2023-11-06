package lotto

import lotto.io.UserInterface

class MoneyInput(
    private val ui:UserInterface
) {

    fun setUserInform():User {
        val amount = ui.askPurchaseAmount()
        val lottoTickets = LottoMaker().makeLottoTickets(amount)

        return User(lottoTickets,amount)
    }


}