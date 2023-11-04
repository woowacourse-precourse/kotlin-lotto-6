package lotto

import lotto.domain.Consumer
import lotto.domain.WinningCheck
import lotto.domain.prizeCheck
import lotto.views.InputView
import lotto.views.OutputView
fun enterMoney() :Int{
    OutputView.printEnterMoney()
    return InputView.enterMoney()
}


fun enterWinningNumber (): List<Int>{
    OutputView.printEnterWinningNumber()
    return InputView.enterWinningNumber()
}

fun enterBonusNumber(winningNumber:List<Int>) : Int{
    OutputView.printEnterBonusNumber()
    return InputView.enterBonusNumber(winningNumber)
}

fun main() {
    val consumer= Consumer()
    val manage = consumer.getManager()
    val myMoney = enterMoney()
    consumer.purchaseLotto(myMoney/1000)
    OutputView.printLotto(manage.getLotto())
    val winningNumber = enterWinningNumber()
    val bonusNumber = enterBonusNumber(winningNumber)
    val winningChecker = WinningCheck()
    val reward = winningChecker.numbersCheck(manage.getLotto(),winningNumber,bonusNumber)
    val prizeChecker = prizeCheck()
    OutputView.printReward(reward)
    println(prizeChecker.checkPrize(reward,myMoney))


}
