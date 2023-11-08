package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round
import kotlin.math.roundToInt

fun main() {
    val money = getMoney()
    val lottoList = makeLottoList(money)
    printLottoList(lottoList)

    val winningNumber = getWinningNumber()
    val bonusNumber = getBonusNumber(winningNumber)
    val result = compareWinningNumber(winningNumber, lottoList, bonusNumber)
    printResult(result)
    calculateProfitRate(result, money)
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
        if (cnt == State.THIRD.value && compareBonusNumber(number, lotto)) {
            matchCount[State.SECOND.value] += 1
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
    println("3개 일치 (5,000원) - ${matchCount[State.FIFTH.value]}개")
    println("4개 일치 (50,000원) - ${matchCount[State.FOURTH.value]}개")
    println("5개 일치 (1,500,000원) - ${matchCount[State.THIRD.value]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${matchCount[State.SECOND.value]}개")
    println("6개 일치 (2,000,000,000원) - ${matchCount[State.FIRST.value]}개")
}

fun calculateProfitRate(matchCount: List<Int>, money: Int) {
    var total = 0.0
    if (matchCount[State.FIFTH.value] != 0) {
        total += matchCount[State.FIFTH.value] * State.FIFTH.price
    } else if (matchCount[State.FOURTH.value] != 0) {
        total += matchCount[State.FOURTH.value] * State.FOURTH.price
    } else if (matchCount[State.THIRD.value] != 0) {
        total += matchCount[State.THIRD.value] * State.THIRD.price
    } else if (matchCount[State.SECOND.value] != 0) {
        total += matchCount[State.SECOND.value] * State.SECOND.price
    } else if (matchCount[State.FIRST.value] != 0) {
        total += matchCount[State.FIRST.value] * State.FIRST.price
    }

    var result = ((total / money) * 10).roundToInt() / 10f
    println("총 수익률은 ${result}%입니다.")
}