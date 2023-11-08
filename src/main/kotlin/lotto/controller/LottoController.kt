package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.domain.BonusNumberValidators
import lotto.domain.PurchaseAmount
import lotto.domain.compareToLotto
import lotto.domain.getEarningRate
import lotto.domain.getTotalAmount
import lotto.domain.matchCheck
import lotto.domain.parser
import lotto.domain.purchaseAmountValidators
import lotto.domain.winningNumberValidators
import lotto.view.OutputView
import lotto.view.printBonusMessage
import lotto.view.printEarningRate
import lotto.view.printPurchaseTotal
import lotto.view.printStartMessage
import lotto.view.printWinningMessage
import lotto.view.printWinningReport
import lotto.view.printWinningStatistics

class LottoController {
    fun start() {
        printStartMessage()
        val amount = purchaseAmountValidators(inputMessage())

        printPurchaseTotal(amount)
        val lottos = makeLottos(amount)

        printWinningMessage()
        val winningNumbers = winningNumberValidators(inputMessage())

        printBonusMessage()
        val bonusNumber = BonusNumberValidators(inputMessage())
        printWinningReport()
        val matches = compareToLotto(lottos, winningNumbers, bonusNumber) // 몇 개씩 당첨되었는지 갯수 반환
        val matchResult = matchCheck(matches)
        printWinningStatistics(matchResult)

        val totalAmount = getTotalAmount(matchResult)
        printEarningRate(getEarningRate(amount, totalAmount))
    }
}

fun inputMessage(): String {
    return Console.readLine().trim()
}

fun makeNumber(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}

fun makeLottos(amount: Int): MutableList<Lotto> {
    val lottos : MutableList<Lotto> = mutableListOf()
    repeat(amount/1000) {
        lottos.add(Lotto(makeNumber()))
    }
    return lottos
}