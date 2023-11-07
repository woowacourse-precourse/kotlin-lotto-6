package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입 금액을 입력해 주세요.") // 사용자가 구입 금액을 입력
    // 입력받은 금액을 정수로 변환 및 잘못된 입력의 경우 예외 발생
    val money = readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.")
    val lottoCount = money / 1000 // 구매할 로또의 수 설정

    // 구매한 로또 개수만큼 로또 생성
    // 1부터 45까지의 숫자 중 무작위로 6개 선택 후, Lotto 객체 생성
    val lotteries = List(lottoCount) { Lotto(
        Randoms.pickUniqueNumbersInRange(
            1, 45, 6).sorted()
    ) }

    println("${lotteries.size}개를 구매했습니다.") // 구매한 로또 개수와 로또 번호들 출력
    lotteries.forEach { println(it) }

    println("\n당첨 번호를 입력해 주세요.") // 당첨 번호 입력
    val winningNums = readWinningNums()

    println("\n보너스 번호를 입력해 주세요.") // 보너스 번호 입력
    val bonusNum = readBonusNum(winningNums)

    // 입력받은 당첨 번호와 로또 목록을 비교
    val result = lottoProcess(lotteries, winningNums, bonusNum)
    printResult(result, money) // 결과 출력
}

// 당첨 번호 가져오는 함수
fun readWinningNums(): Set<Int> {
    // 입력한 번호 쉼표로 분리 후 정수 변환
    val nums = Console.readLine().split(",").map { it.trim().toIntOrNull() }
    // 번호 중에 null이거나, 6개가 아닌 경우
    if (nums.any { it == null } || nums.size != 6) {
        throw IllegalArgumentException("[ERROR] 유효하지 않은 당첨 번호입니다.")
    }

    return nums.mapNotNull { it }.toSet()
}

// 보너스 번호 가져오는 함수
fun readBonusNum(wonNumbers: Set<Int>): Int {
    // 보너스 번호 정수로 변환
    val bonus = Console.readLine().trim().toIntOrNull()
    // 보너스 번호가 유효하지 않은 경우
    if (bonus == null || bonus !in 1..45 || bonus in wonNumbers)
        throw IllegalArgumentException("[ERROR] 유효하지 않은 보너스 번호입니다.")

    return bonus
}

// 결과 계산 함수
fun lottoProcess(
    lotteries: List<Lotto>, winningNums: Set<Int>, bonusNums: Int): Map<Int, Int>
{
    // 결과를 저장할 맵 초기화
    val results = mutableMapOf(
        3 to 0, 4 to 0, 5 to 0, 5 to 0, 6 to 0
    )

    // 당첨 번호와 얼마나 일치하는지 계산
    lotteries.forEach { lotto ->
        val match = lotto.matches(winningNums)
        // 5개가 일치하고 보너스 번호도 일치하는지 확인
        val isBonus =
            if (match == 5) lotto.contains(bonusNums)
            else false

        // 3개 이상 일치하는 경우
        if (match >= 3) {
            val key = if (isBonus) 5 else match
            results[key] = results.getOrDefault(key, 0) + 1
        }
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
