package lotto

import lotto.domain.Consumer
import lotto.domain.Grade
import lotto.domain.WinningCheck
import lotto.domain.Prize
import lotto.views.InputView
import lotto.views.OutputView

fun enterMoney(): Int {
    OutputView.printEnterMoney()
    return InputView.enterMoney()
}


fun enterWinningNumber(): List<Int> {
    OutputView.printEnterWinningNumber()
    return InputView.enterWinningNumber()
}

fun enterBonusNumber(winningNumber: List<Int>): Int {
    OutputView.printEnterBonusNumber()
    return InputView.enterBonusNumber(winningNumber)
}

fun printPrize(reward: List<Grade>, myMoney: Int) {
    val prizeChecker = Prize()
    OutputView.printPrize(reward)
    OutputView.printYield(prizeChecker.getPrizeRatio(reward, myMoney))
}

fun playLotto() {
    val consumer = Consumer()
    val manage = consumer.getManager()
    val myMoney = enterMoney()
    consumer.purchaseLotto(myMoney / 1000)
    OutputView.printLotto(manage.getLotto())
    val winningNumber = enterWinningNumber()
    val bonusNumber = enterBonusNumber(winningNumber)
    val winningChecker = WinningCheck()
    val reward = winningChecker.numbersCheck(manage.getLotto(), winningNumber, bonusNumber)
    printPrize(reward, myMoney)
}

fun main() {
    playLotto()
}
