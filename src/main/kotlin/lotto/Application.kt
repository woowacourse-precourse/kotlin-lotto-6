package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

fun main() {
    val money = readMoney()
    val count = money / 1000
    val lotteries = setLotteries(count)

    printLotto(lotteries)

    val winningNums = readWinningNums()
    val bonusNumber = readBonusNum(winningNums)

    val result = checkResults(lotteries, winningNums, bonusNumber)
    printResult(result, money)
}

// 입력하는 부분 (구입 금액 입력)
fun readMoney(): Int {
    println("구입 금액을 입력해주세요.")
    val money = readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 정확한 금액이 아닙니다.")
    if (money < 1000)
        throw IllegalArgumentException("[ERROR] 구입 금액이 너무 적습니다.")
    return money
}

// 로또 만드는 함수
fun setLotteries(count: Int): List<Lotto> {
    return List(count) {
        Lotto(Randoms.pickUniqueNumbersInRange(
            1, 45, 6).sorted()
        )
    }
}

// 구매한 로또 번호 출력하기
fun printLotto(lotteries: List<Lotto>) {
    println("${lotteries.size}개를 구매했습니다.")
    lotteries.forEach { println(it.getNumbers()) } // getNumbers 메서드로 numbers 접근
}

// 당첨 번호 입력하기
fun readWinningNums(): Set<Int> {
    println("당첨 번호를 입력해 주세요.")
    return readNums()
}

// 번호 읽어서 Set 반환하기
fun readNums(): Set<Int> {
    return readLine()!!.split(",")
        .mapNotNull { it.trim().toIntOrNull() }
        .toSet()
        .also { if (it.size != 6)
            throw IllegalArgumentException("[ERROR] 정확하지 않은 로또 번호입니다.") }
}

// 보너스 번호 가져오는 함수
fun readBonusNum(wonNumbers: Set<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    // 보너스 번호 정수로 변환
    while (true) {
        val bonus = Console.readLine().trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 정확하지 않은 보너스 번호입니다.")
        if (bonus in 1..45 && bonus !in wonNumbers) {
            return bonus
        } else {
            println("[ERROR] 정확하지 않은 보너스 번호입니다.")
        }
    }
}

// 당첨 결과 확인 함수
fun checkResults(lotteries: List<Lotto>, wonNums: Set<Int>, bonusNum: Int): Map<Rank, Int> {
    // 모든 등수 당첨 개수 0으로 설정
    val results = Rank.values().associateWith { 0 }.toMutableMap()

    lotteries.forEach { lotto ->
        val matchCount = lotto.getNumbers().count { it in wonNums } // 당첨 번호와 일치 개수
        val matchBonus = bonusNum in lotto.getNumbers() // 보너스 번호 포함 여부
        val rank = Rank.valueOf(matchCount, matchBonus) // 일치 번호와 보너스 번호 여부
        results[rank] = results[rank]!! + 1 // 등수 당첨 개수 1 증가
    }

    return results
}

// 결과 출력 함수
fun printResult(lottoResults: Map<Rank, Int>, money: Int) {
    // 각 당첨 별 상금 설정
    lottoResults.forEach { (rank, count) ->
        if (count > 0)
            println("${rank.matchNum}개 일치 (${rank.winningMoney}원)- $count 개")
    }

    // 수익금 계산
    val totalMoney = lottoResults.entries.sumOf {
        it.key.winningMoney * it.value }

    val returnRate = (totalMoney.toDouble() / money) * 100 // 수익률 계산
    println("총 수익률은 ${"%.2f".format(returnRate)}% 입니다.") // 수익률 출력
}

@Test
fun `match count is correct`() {
    // 준비
    val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6).toList())
    val winningNumbers = setOf(4, 5, 6, 7, 8, 9)

    // 실행
    val matchCount = lotto.matches(winningNumbers)

    // 검증
    assertThat(matchCount).isEqualTo(3)
}

@Test
fun `bonus number is correctly identified`() {
    // 준비
    val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6).toList())
    val winningNumbers = setOf(4, 5, 6, 7, 8, 9)
    val bonusNumber = 1

    // 실행
    val matchCount = lotto.matches(winningNumbers)
    val matchesBonus = lotto.contains(bonusNumber)

    // 검증
    assertThat(matchCount).isEqualTo(3)
    assertThat(matchesBonus).isTrue
}
