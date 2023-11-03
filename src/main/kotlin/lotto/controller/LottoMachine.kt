package lotto.controller

import lotto.model.*
import lotto.view.Input
import lotto.view.Output

class LottoMachine {
    fun start(){
        val money = moneyInput()
        val count = Count().calculate(money)
        val userLotto = purchaseNumberLotto(count)
        val answers = userAnswer()
        val bonus = userBonus()



    }
    fun userBonus():Int{
        Output().printWriteBonus()
        val bonus = Input().write()
        Bonus().BonusFomatValidate(bonus)
        return bonus.toInt()
    }
    fun userAnswer():List<Int>{
        Output().printWriteAnswer()
        val answers = Input().write()
        val userAnswerInput = UserLottoNumber().convert(answers)
        return userAnswerInput
    }

    fun purchaseNumberLotto(count:Int) :List<List<Int>>{
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
        Money().MoneyFomatValidate(money)
        Money().MoneyRangeValidate(money)
        Money().MoneyChangesValidate(money)
        return money.toInt()
    }
}