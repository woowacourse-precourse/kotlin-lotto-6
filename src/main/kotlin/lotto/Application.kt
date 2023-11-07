package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = purchaseMoney() // 로또 구매 금액 입력
    val lottery = purchaseLotto(money / 1000) // 로또 생성
    printLotto(lottery) // 구매한 로또 출력(임의로 숫자 설정)

    val winningNums = winningNumber() // 당첨 번호 설정
    val bonusNum = bonusNumber() // 보너스 번호 설정

    val wonLottery = checkLotto(lottery, winningNums, bonusNum)
    printResults(wonLottery, money)
}

// 사용자가 구입 금액 입력 함수
fun purchaseMoney(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
    if (money < 1000 || money % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
    }
    return money
}

// 구매한 로또 개수 입력 함수 (임의로 6개 설정)
fun purchaseLotto(lottoCnt: Int): List<List<Int>> {
    return List(lottoCnt) {
        // 중복되지 않는 6개 숫자 설정
        Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}

// 구매한 로또 개수 출력하기
fun printLotto(lotto: List<List<Int>>) {
    println("${lotto.size}개를 구매했습니다.")
    lotto.forEach { println(it) }
}

// 당첨 번호 입력하는 함수
fun winningNumber(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return Console.readLine().split(",").map { it.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
    }
}

// 보너스 번호 입력하는 함수
fun bonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
}

// 당첨 통계 및 수익률 출력 함수
fun printResults(wonLottery: Lotto, money: Int) {
    println("당첨 통계")
    println("---")
    wonLottery.printStat()
    println("총 수익률은 ${wonLottery.rateReturn(money)}입니다.")

}

// 당첨 번호 확인 함수
fun checkLotto(lottery: List<List<Int>>, winningNums: List<Int>, bonusNum: Int): Lotto {
    val result = Lotto(lottery)
    for (ticket in lottery) {
        val match = ticket.count { it in winningNums }
        val isBounus = bonusNum in ticket
        lotto.matchBonus(match, isBounus)
    }
    return lotto
}