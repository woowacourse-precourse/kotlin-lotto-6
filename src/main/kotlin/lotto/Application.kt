package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val money = getMoney()
    val lottoList = makeLottoList(money)
    printLottoList(lottoList)
    val winningNumber = getWinningNumber()
    val bonusNumber = getBonusNumber(winningNumber)
    val result = compareWinningNumber(winningNumber, lottoList, bonusNumber)
    println(result.toString())
    printResult(result)
}

fun getMoney(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine().trim()
    ExceptionHandler.checkInputMoney(money)
    return money.toInt()
}

fun makeLotto(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers.sorted())
}

fun makeLottoList(money: Int): List<Lotto> {
    val lottoList = mutableListOf<Lotto>()
    val cnt = money / 1000

    for (i in 1..cnt) {
        lottoList.add(makeLotto())
    }

    return lottoList
}

fun printLottoList(lottos: List<Lotto>) {
    val cnt = lottos.size
    println("${cnt}개를 구매했습니다.")
    for (lotto in lottos) {
        println(lotto.toString())
    }
}

fun getWinningNumber(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val numbers = Console.readLine().trim()
    var numberList = numbers.split(",")
    val winningNumberList = mutableListOf<Int>()

    for (i in numberList) {
        winningNumberList.add(i.toInt())
    }

    ExceptionHandler.checkNumberList(winningNumberList)
    return winningNumberList
}

fun getBonusNumber(winningNumber: List<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    val number = Console.readLine().trim()
    ExceptionHandler.checkBonusNumber(number, winningNumber)

    return number.toInt()
}

fun countInWinningNumber(winningNumber: List<Int>, lotto: Lotto): Int {
    var cnt = 0
    for (number in lotto.numberList) {
        if (winningNumber.contains(number)) {
            cnt += 1
        }
    }
    return cnt
}


fun compareWinningNumber(winningNumber: List<Int>, lottos: List<Lotto>, number: Int): List<Int> {
    val matchCount = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)  // (0, 1, 2, 3, 4, 5, 6, 5+보너스)
    for (lotto in lottos) {
        val cnt = countInWinningNumber(winningNumber, lotto)

        // 2등 확인
        if (cnt == 5 && compareBonusNumber(number, lotto)) {
            matchCount[7] += 1
            continue
        }
        matchCount[cnt] += 1
    }
    return matchCount
}

fun compareBonusNumber(bonusNumber: Int, lotto: Lotto): Boolean {
    if (lotto.contains(bonusNumber)) {
        return true
    }
    return false
}

fun printResult(matchCount: List<Int>){
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${matchCount[State.FIFTH.value]}")
    println("4개 일치 (50,000원) - ${matchCount[State.FOURTH.value]}")
    println("5개 일치 (1,500,000원) - ${matchCount[State.THIRD.value]}")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${matchCount[State.SECOND.value]}")
    println("6개 일치 (2,000,000,000원) - ${matchCount[State.FIRST.value]}")
}