package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.roundToInt

fun main() {
    val money = getMoney()
    val lottos = makeLottos(money)
    printLottos(lottos)

    val winningNumber = getWinningNumber()
    val bonusNumber = getBonusNumber(winningNumber)
    val result = compareWinningNumber(winningNumber, lottos, bonusNumber)

    printResult(result)
    calculateProfitRate(result, money)
}

fun getMoney(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine().trim()
    try {
        ExceptionHandler.checkInputMoney(money)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]")
        return getMoney()
    }
    return money.toInt()
}

fun makeLotto(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers.sorted())
}

fun makeLottos(money: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()
    val cnt = money / 1000

    for (i in 1..cnt) {
        lottos.add(makeLotto())
    }

    return lottos
}

fun printLottos(lottos: List<Lotto>) {
    val cnt = lottos.size
    println("${cnt}개를 구매했습니다.")
    for (lotto in lottos) {
        println(lotto.toString())
    }
}

fun getWinningNumber(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val inputNumbers = Console.readLine().trim()

    try {
        ExceptionHandler.checkWinningNumber(inputNumbers)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]")
        return getWinningNumber()
    }

    var numbers = inputNumbers.split(",")
    val winningNumber = mutableListOf<Int>()
    for (i in numbers) {
        winningNumber.add(i.toInt())
    }

    try {
        ExceptionHandler.checkNumberList(winningNumber)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]")
        return getWinningNumber()
    }
    return winningNumber
}

fun getBonusNumber(winningNumber: List<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    val number = Console.readLine().trim()

    try {
        ExceptionHandler.checkBonusNumber(number, winningNumber)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]")
        return getBonusNumber(winningNumber)
    }

    return number.toInt()
}

fun countInWinningNumber(winningNumber: List<Int>, lotto: Lotto): Int {
    var cnt = 0
    for (number in lotto.lotteryNumber) {
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

fun printResult(matchCount: List<Int>) {
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

    for(state in State.values()){
        if(matchCount[state.value] != 0){
            total += matchCount[state.value] * state.price
        }
    }

    val result = ((total / money) * 1000).roundToInt() / 10f
    println("총 수익률은 ${result}%입니다.")
}