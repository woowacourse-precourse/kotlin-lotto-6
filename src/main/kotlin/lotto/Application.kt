package lotto

import ui.Output

fun main() {
    play()
}

fun play() {
    val buy = Buy()
    val amount = buy.buyLotto()
    Output.printLottoCount(amount)

    val userLotto = buy.generateLottos(amount)
    Output.printUserLottos(userLotto)

    val winningLotto = UserLotto().createUserLotto()
    val bonusNumber = BonusNumber().createBonusNumber(winningLotto)

    val prize = getPrize(userLotto, winningLotto, bonusNumber)
    Output.printMatchResult(getPrizeList(prize))
    Output.printEarnRate(getEarningRate(prize, amount))
}
