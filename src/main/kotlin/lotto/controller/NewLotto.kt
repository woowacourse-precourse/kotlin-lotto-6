package lotto.controller

import lotto.model.Validation
import lotto.view.Input
import lotto.view.Output

class NewLotto {
    fun start(){
        val money = moneyInput()



    }
    fun moneyInput():Int{
        Output().printWriteMoney()
        val money = Input().write()
        Validation().MoneyFomatValidate(money)
        Validation().MoneyRangeValidate(money)
        Validation().MoneyChangesValidate(money)
        return money.toInt()
    }
}