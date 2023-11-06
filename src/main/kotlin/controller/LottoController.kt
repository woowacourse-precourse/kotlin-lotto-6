package controller

import domain.chance.Chance
import lotto.domain.purchase.Money
import lotto.view.InputView
import view.ResultView

object LottoController {

    private lateinit var money: Money
    private lateinit var chance: Chance

    fun startGame() {
        money = getUserAmount()
        chance = getChance(money)
        ResultView.printNumberOfLottiesPurchased(chance)

    }

    private fun getUserAmount(): Money = Money(InputView.inputPurchaseAmount())

    private fun getChance(money: Money) = Chance(money)
}