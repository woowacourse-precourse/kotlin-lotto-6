package lotto.controller

import lotto.model.Count
import lotto.model.Lotto
import lotto.model.Random
import lotto.model.Validation
import lotto.view.Input
import lotto.view.Output

class NewLotto {
    fun start(){
        val money = moneyInput()
        val count = Count().calculate(money)
        val userLotto = PurchaseNumberLotto(count)


    }
    fun PurchaseNumberLotto(count:Int) :List<List<Int>>{
        Output().printPurchase(count)
        val userLotto: MutableList<List<Int>> = mutableListOf()
        val lotto = Random().lottoGenerator()
        repeat(count) {
            userLotto.add(Lotto(lotto).serve())
            Output().printLottoNumbers(lotto)
        }
        return userLotto
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