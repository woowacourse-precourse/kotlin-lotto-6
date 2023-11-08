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
    println("${Message.INQUIRE_MONEY.msg}")
    val money = Console.readLine().trim()
    try {
        ExceptionHandler.checkInputMoney(money)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]로또 구입 금액은 1000원으로 나누어 떨어져야 합니다. ")
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
    println("${cnt}${Message.PRINT_LOTTO.msg}")
    for (lotto in lottos) {
        println(lotto.toString())
    }
}

fun getWinningNumber(): List<Int> {
    println("${Message.INQUIRE_WINNING_NUMBER.msg}")
    val inputNumbers = Console.readLine().trim()

    try {
        ExceptionHandler.checkWinningNumber(inputNumbers)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]숫자는 1부터 45 범위의 수 입니다. ")
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
        print("[ERROR]로또는 6개의 숫자입니다. ")
        return getWinningNumber()
    }
    return winningNumber
}

fun getBonusNumber(winningNumber: List<Int>): Int {
    println("${Message.INQUIRE_BONUS_NUMBER.msg}")
    val number = Console.readLine().trim()

    try {
        ExceptionHandler.checkBonusNumber(number, winningNumber)
    } catch (e: IllegalArgumentException) {
        print("[ERROR]보너스 숫자는 당첨 번호와 중복될 수 없는 1부터 45 범위의 수 입니다. ")
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