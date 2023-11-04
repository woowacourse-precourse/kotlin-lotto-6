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
        val bonus = userBonus(answers)
        val jackpot = Jackpot().discriminate(answers,bonus,userLotto)
        val profit = Profit().calculateProfit(money,jackpot)
        Output().printAnswerCompare(jackpot,profit)
    }
    fun userBonus(answers: List<Int>):Int{
        Output().printWriteBonus()
        val bonus = Input().write()
        Bonus().BonusFomatValidate(bonus)
        Bonus().BonuDuplicationValidate(bonus.toInt(),answers)
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

        repeat(count) {
            val lotto = Random().lottoGenerator()
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