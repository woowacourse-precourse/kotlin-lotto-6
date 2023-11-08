package lotto

import lotto.domain.*
import lotto.views.OutputView
import java.lang.IllegalArgumentException

fun main() {
    try {
        playLotto()
    } catch (e: IllegalArgumentException) {
    }
}

fun playLotto() {
    val purchase = Purchase()
    val amount = purchase.buyLotto()
    OutputView.printAmount(amount)
    val lottos = purchase.createLottos(amount)
    OutputView.printLottos(lottos)
    val winningLotto = WinningLotto().createWinningLotto()
    val bonusNumber = BonusNumber().createBonusNumber(winningLotto)
    val rewards = getReward(lottos, winningLotto, bonusNumber)
    OutputView.printCountReward(countReward(rewards))
    OutputView.printYield(calculateYield(rewards, amount))
}