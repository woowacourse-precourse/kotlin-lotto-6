package controller

import lotto.domain.purchase.Money
import lotto.view.InputView

object LottoController {

    private lateinit var money: Money

    fun startGame() {
        money = getUserAmount()
    }

    private fun getUserAmount(): Money = Money(InputView.inputPurchaseAmount())


}