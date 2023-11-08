package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

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

/* 사용자 입력 부분 */
// 입력하는 부분 (구입 금액 입력)
fun readMoney(): Int {
    while (true) {
        try {
            println("구입 금액을 입력해주세요.")
            val input = Console.readLine()
            val money = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] 정확한 금액이 아닙니다!!")
            if (money < 1000 || money % 1000 != 0)
                throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 양수여야 합니다!!")
            return money
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

// 로또 만드는 함수
fun setLotteries(count: Int): List<Lotto> {
    return List(count) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                1, 45, 6
            ).sorted()
        )
    }
}

// 구매한 로또 번호 출력하기
fun printLotto(lotteries: List<Lotto>) {
    println("${lotteries.size}개를 구매했습니다.")
    // getNumbers 메서드로 numbers 접근
    lotteries.forEach { println(it.getNumbers().joinToString()) }
}

// 당첨 번호 입력하기
fun readWinningNums(): Set<Int> {
    while (true) {
        try {
            println("당첨 번호를 쉼표로 구분하여 입력해 주세요.")
            val input = Console.readLine()
            val numbers = input.split(",").map { it.trim().toIntOrNull() }
            if (numbers.size != 6 || numbers.any { it == null || it !in 1..45 })
                throw IllegalArgumentException("[ERROR] 정확하지 않은 로또 번호입니다!!")
            return numbers.filterNotNull().toSet()
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자만 입력해야 합니다!!")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

// 보너스 번호 가져오는 함수
fun readBonusNum(wonNumbers: Set<Int>): Int {
    // 보너스 번호 정수로 변환
    while (true) {
        try {
            println("보너스 번호를 입력해 주세요.")
            val input = Console.readLine()
            val bonus = input.toIntOrNull()
            if (bonus == null || bonus !in 1..45)
                throw IllegalArgumentException("[ERROR] 정확하지 않은 보너스 번호입니다!!")
            if (bonus in wonNumbers)
                throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다!!")
            return bonus
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자만 입력해야 합니다!!")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

/* 결과 부분 */
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
    printStatistics(lottoResults) // 통계 출력
    println()
    printReturnRate(lottoResults, money) // 수익률 계산 및 출력
}

fun printReturnRate(lottoResults: Map<Rank, Int>, money: Int) {
    // 수익금 계산
    val totalMoney = lottoResults.entries.sumOf {
        it.key.winningMoney * it.value
    }

    val returnRate = (totalMoney.toDouble() / money) * 100 // 수익률 계산
    println("\n수익금 계산")
    println("---")
    println("총 수익금은 ${totalMoney}원입니다.")
    println("총 수익률은 ${"%.1f".format(returnRate)}%입니다.")
}

fun printStatistics(lottoResults: Map<Rank, Int>) {
    println("당첨 통계")
    println("---")

    lottoResults.entries.forEach { (rank, count) ->
        if (count > 0) {
            val resultString = when (rank) { // 등수별 일치 여부 및 상금 설정
                Rank.Rank1 -> "6개 일치 (2,000,000,000원)"
                Rank.Rank2 -> "5개 일치, 보너스 볼 일치 (30,000,000원)"
                Rank.Rank3 -> "5개 일치 (1,500,000원)"
                Rank.Rank4 -> "4개 일치 (50,000원)"
                Rank.Rank5 -> "3개 일치 (5,000원)"
                else -> ""
            }
            println("$resultString - $count 개")
        }
    }
}
