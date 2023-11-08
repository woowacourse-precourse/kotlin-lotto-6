package lotto.controller

import lotto.model.*
import lotto.util.Count
import lotto.util.IntegerConverter
import lotto.util.Random
import lotto.view.Input
import lotto.view.Output

class LottoMachine {
    fun start() {
        val money = moneyInput()
        val count = Count().calculate(money)

        val userLotto = purchaseNumberLotto(count)
        val answers = userAnswer()
        val bonus = userBonus(answers)

        val jackpot = Jackpot().discriminate(answers, bonus, userLotto)
        val profit = Profit().calculateProfit(money, jackpot)
        Output().printAnswerCompare(jackpot, profit)
    }

    fun moneyInput(): Int {
        Output().printWriteMoney()
        val money = Input().write()
        return try {
            Money().moneyFormatValidate(money)
            Money().moneyRangeValidate(money)
            Money().moneyChangesValidate(money)
            money.toInt()
        } catch (e: IllegalArgumentException) {
            moneyInput()
        }
    }

    fun purchaseNumberLotto(count: Int): List<List<Int>> {
        Output().printPurchase(count)
        val userLotto: MutableList<List<Int>> = mutableListOf()
        repeat(count) {
            val lotto = Random().lottoGenerator().sorted()
            userLotto.add(Lotto(lotto).serve())
            Output().printLottoNumbers(lotto)
        }
        return userLotto
    }

    fun userAnswer(): List<Int> {
        Output().printWriteAnswer()
        val answers = Input().write()
        val userLottoAnswer = IntegerConverter().convert(answers)
        return try {
            Lotto(userLottoAnswer).rangeValidate()
            userLottoAnswer
        } catch (e: IllegalArgumentException) {
            userAnswer()
        }
    }
}

fun userBonus(answers: List<Int>): Int {
    Output().printWriteBonus()
    val bonus = Input().write()
    return try {
        Bonus().BonusFomatValidate(bonus)
        Bonus().BonuDuplicationValidate(bonus.toInt(), answers)
        Bonus().BonusRangeValidate(bonus.toInt())
        bonus.toInt()
    } catch (e: IllegalArgumentException) {
        userBonus(answers)
    }
}

