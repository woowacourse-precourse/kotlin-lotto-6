package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = purchaseMoney() // 로또 구매 금 입력
    val lotto = purchaseLotto(money / 1000) // 로또 생성
    printLotto(lotto) // 구매한 로또 출력

    val winningNums = winningNumber()
    val bonusNum = bonusNumber()
    print("구입금액을 입력해 주세요.")
//
//    print("당첨 번호를 입력해 주세요.")
//    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
//
//    print("보너스 번호를 입력해 주세요.")

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

// 구매한 로또 개수 입력 함수
fun purchaseLotto(lottoCnt: Int): List<List<Int>> {
    return List(lottoCnt) {
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
