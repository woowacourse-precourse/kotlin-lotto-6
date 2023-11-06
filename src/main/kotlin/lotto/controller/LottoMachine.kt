package lotto.controller

import lotto.model.*
import lotto.view.Input
import lotto.view.Output
import java.util.Scanner

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
        var money = Input().write()
        var validFlag = true
        while (validFlag) {
            try {
                Money().moneyFormatValidate(money)
                Money().moneyRangeValidate(money)
                Money().moneyChangesValidate(money)
                validFlag = false
            } catch (e: IllegalArgumentException) {
                money = Input().write()
            }
        }
        return money.toInt()
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
        var answers = Input().write()
        var userLottoAnswer = UserLottoNumber().convert(answers)
        var validFlag = true
        while (validFlag) {
            try {
                Lotto(userLottoAnswer).rangeValidate()
                Lotto(userLottoAnswer).duplicationValidate()
                UserLottoNumber().sizeValidate(userLottoAnswer)
                validFlag = false
            } catch (e: IllegalArgumentException) {
                answers = Input().write()
                userLottoAnswer = UserLottoNumber().convert(answers)
            }
        }
        return userLottoAnswer
    }

    fun userBonus(answers: List<Int>): Int {
        Output().printWriteBonus()
        var bonus = Input().write()
        var validFlag = true
        while (validFlag) {
            try {
                Bonus().BonusFomatValidate(bonus)
                Bonus().BonuDuplicationValidate(bonus.toInt(), answers)
                validFlag = false
            } catch (e: IllegalArgumentException) {
                bonus = Input().write()
            }
        }

        return bonus.toInt()
    }


}