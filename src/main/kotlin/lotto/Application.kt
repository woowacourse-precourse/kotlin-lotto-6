package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.PurchaseAmount
import lotto.view.OutputView.printBonusMessage
import lotto.view.OutputView.printPurchaseTotal
import lotto.view.OutputView.printStartMessage
import lotto.view.OutputView.printWinningMessage
import lotto.view.OutputView.printWinningReport

fun main() {
//    try {
//
//
//
//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//        main()
//    }

    var lottos : MutableList<Lotto> = mutableListOf()

    printStartMessage()
    val amount = PurchaseAmount().validators(inputMessage())

    printPurchaseTotal(amount)
    repeat(amount/1000) {
        lottos.add(Lotto(makeLotto()))
    }

//        var lotto = lottoSort(makeLotto())

    printWinningMessage()
    val winningNumber = inputMessage().trim()
    val winningResult = parser(winningNumber)

    printBonusMessage()
    val BonusNumber = inputMessage().trim()

    printWinningReport()
    compareToLotto(lottos, winningResult)

}



fun inputMessage(): String {
    return Console.readLine().trim()
}

fun makeLotto(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}

// 쉼표로 나누기, 정수로 변경
fun parser(s: String): List<Int> {
    val win = s.split(",")
    return win.map { it.toInt() }
}

// 당첨 번호와 로또 번호 비교
fun compareToLotto(lottos: MutableList<Lotto>, winningResult: List<Int>) {
    val union = lottos + winningResult
    val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }
    println(intersection.size)
}