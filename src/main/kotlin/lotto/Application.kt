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
//    } catch (e: IllegalArgumentException) {
//        println(e.message)
//        main()
//    }

    val lottos : MutableList<Lotto> = mutableListOf()

    printStartMessage()
    val amount = PurchaseAmount.validators(inputMessage())

    printPurchaseTotal(amount)
    repeat(amount/1000) {
        lottos.add(Lotto(makeNumber()))
    }

    printWinningMessage()
    val winningNumber = inputMessage().trim()
    val winningResult = parser(winningNumber)

    printBonusMessage()
    val BonusNumber = inputMessage().trim().toInt()
    val bonus = matchBonus(lottos, winningResult, BonusNumber)

    printWinningReport()
    val matches = compareToLotto(lottos, winningResult)
    matchCheck(matches, bonus)

    // 수익률 구하기
    val totalAmount = getTotalAmount(matches, bonus)
    getEarningRate(amount, totalAmount)

}

fun inputMessage(): String {
    return Console.readLine().trim()
}

fun makeNumber(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}

// 쉼표로 나누기, 정수로 변경
fun parser(s: String): List<Int> {
    val win = s.split(",")
    return win.map { it.toInt() }
}

// 당첨 번호와 로또 번호 비교
fun compareToLotto(lottos: MutableList<Lotto>, winningResult: List<Int>): MutableList<Int> {
    val matchSize : MutableList<Int> = mutableListOf()
    for(index in lottos.indices) {
        val union = lottos[index].getNumbers() + winningResult
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
        matchSize.add(intersection.size)
    }
    return matchSize
}

fun matchBonus(lottos: MutableList<Lotto>, winningResult: List<Int>, BonusNumber: Int): Int {
    var bonus = 0
    for(index in lottos.indices) {
        val union = lottos[index].getNumbers() + winningResult
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()

        if(intersection.size == 5 && lottos[index].getNumbers().contains(BonusNumber)) {
            bonus++
        }
    }
    return bonus
}

// 당첨된 횟수 적립
fun matchCheck(matches: MutableList<Int>, bonus: Int) {
    var matchThree = 0
    var matchFour = 0
    var matchFive = 0
    var matchSix = 0

    for (index in matches.indices) {
        when(matches[index]) {
            3 -> matchThree++
            4 -> matchFour++
            5 -> matchFive++
            6 -> matchSix++
        }
    }

    println("3개 일치 (5,000원) - ${matchThree}개")
    println("4개 일치 (50,000원) - ${matchFour}개")
    println("5개 일치 (1,500,000원) - ${matchFive-bonus}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${bonus}개")
    println("6개 일치 (2,000,000,000원) - ${matchSix}개")

}

// 당첨된 금액 합계
fun getTotalAmount(matches: MutableList<Int>, bonus: Int): Int {
    var total = 0
    for (index in matches.indices) {
        when(matches[index]) {
            3 -> total =+ 5000
            4 -> total =+ 50000
            5 -> total =+ 1500000
            6 -> total =+ 2000000000
        }
    }

    if(bonus != 0) {
        total -= 1500000 * bonus
        total += 30000000 * bonus
    }
    return total
}

// 수익률 구하기
fun getEarningRate(amount: Int, total: Int) {
    val amount = amount.toFloat()
    val total = total.toFloat()
    println((total/amount)*100)
}