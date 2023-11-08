package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.domain.BonusNumberValidators
import lotto.domain.PurchaseAmount
import lotto.domain.compareToLotto
import lotto.domain.matchCheck
import lotto.domain.parser
import lotto.domain.winningNumberValidators
import lotto.view.OutputView
import lotto.view.printBonusMessage
import lotto.view.printEarningRate
import lotto.view.printPurchaseTotal
import lotto.view.printStartMessage
import lotto.view.printWinningMessage
import lotto.view.printWinningReport

class LottoController {
    fun start() {
        printStartMessage()
        val amount = PurchaseAmount.validators(inputMessage())

        printPurchaseTotal(amount)
        val lottos = makeLottos(amount)

        printWinningMessage()
        val winningNumbers = winningNumberValidators(inputMessage())


        printBonusMessage()
        val bonusNumber = BonusNumberValidators(inputMessage())
        printWinningReport()
        val matches = compareToLotto(lottos, winningNumbers, bonusNumber) // 몇 개씩 당첨되었는지 갯수 반환
        matchCheck(matches)
//
//        // 수익률 구하기
//        val totalAmount = getTotalAmount(matches)
//        printEarningRate(getEarningRate(amount, totalAmount))
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



// 당첨된 금액 합계
fun getTotalAmount(matches: Pair<MutableList<Int>, Int>): Int {
    var total = 0
    for (index in matches.first.indices) {
        when(matches.first[index]) {
            3 -> total =+ 5000
            4 -> total =+ 50000
            5 -> total =+ 1500000
            6 -> total =+ 2000000000
        }
    }

    if(matches.second != 0) {
        total -= 1500000 * matches.second
        total += 30000000 * matches.second
    }
    return total
}

// 수익률 구하기
fun getEarningRate(amount: Int, total: Int): Float {
    val amount = amount.toFloat()
    val total = total.toFloat()
    return (total/amount)*100
}