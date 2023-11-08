package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val money = getMoney()
    val lottoList = makeLottoList(money)
    printLottoList(lottoList)
    val winningNumber = getWinningNumber()
    println(getBonusNumber(winningNumber))
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