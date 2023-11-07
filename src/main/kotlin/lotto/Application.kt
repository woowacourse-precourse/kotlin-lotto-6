package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    val (tickets, purchaseAmount) = buyTickets()
    println("${tickets.size}개를 구매했습니다.")
    val (winningNumbers, bonusNumber) = getWinningNumbersAndBonus()
    val results = getResults(tickets, winningNumbers, bonusNumber)
    println("당첨 통계")
    println("---")
    printResults(results, purchaseAmount)
}

fun printResults(results: List<LottoResult>, purchaseAmount: Int) {
    val resultCounts = countResults(results)
    printResultMessages(resultCounts)
    val profitRate = calculateProfitRate(results, purchaseAmount)
    printProfitRate(profitRate)
}
//결과값 출력
fun countResults(results: List<LottoResult>): Map<LottoResult, Int> {
    return results.groupingBy { it }.eachCount()
}
//결과 집계
fun printResultMessages(resultCounts: Map<LottoResult, Int>) {
    for (result in LottoResult.values()) {
        if (result != LottoResult.NONE) {
            val count = resultCounts[result] ?: 0
            println(result.getFormattedResult(count))
        }
    }
}
//결과 출력
fun calculateProfitRate(results: List<LottoResult>, purchaseAmount: Int): Double {
    val totalPrize = results.sumOf { it.prize }
    return totalPrize.toDouble() / purchaseAmount * 100
}
//수익률 계산
fun printProfitRate(profitRate: Double) {
    println("총 수익률은 ${profitRate}%입니다.")
}
//수익률 표기


fun buyTickets(): Pair<List<Lotto>, Int> {
    val purchaseAmount = getValidPurchaseAmount()
    val tickets = buyLottoTickets(purchaseAmount)
    return tickets to purchaseAmount
}
//로또 구매
fun getWinningNumbersAndBonus(): Pair<List<Int>, Int> {
    val winningNumbers = getValidWinningNumbers()
    val bonusNumber = getValidBonusNumber(winningNumbers)
    return winningNumbers to bonusNumber
}
//당첨번호 및 보너스 번호 확인

fun getResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<LottoResult> {
    return tickets.map { it.getLottoResult(winningNumbers, bonusNumber) }
}
//결과출력

fun buyLottoTickets(purchaseAmount: Int): List<Lotto> {
    val ticketCount = purchaseAmount / 1000
    return List(ticketCount) {
        val numbers = generateLottoNumbers()
        val lotto = Lotto(numbers)
        println(lotto.toString())
        lotto
    }
}
//로또티켓구매
fun inputPurchaseAmount(): String {
    println("구입금액을 입력해 주세요.")
    return Console.readLine()
}
//로또구매장수 입력받기

fun getValidPurchaseAmount(): Int {
    while (true) {
        val input = inputPurchaseAmount()
        try {
            val amount = input.toInt()
            if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.")
            }
            return amount
        } catch (e: NumberFormatException) {
            println("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
//사용자 구매 유효성 체크

fun generateLottoNumbers(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
//로또번호 랜덤 생성
fun inputWinningNumbers(): String {
    println("당첨 번호를 입력해 주세요.")
    return Console.readLine()
}
//당첨 번호 입력 받기

fun getValidWinningNumbers(): List<Int> {
    while (true) {
        val input = inputWinningNumbers()
        try {
            val numbers = input.split(",").map { it.toInt() }
            if (numbers.size != 6) {
                throw IllegalArgumentException("[ERROR] 로또 당첨 번호는 콤마로 구분된 6개의 숫자로 입력해야 합니다.")
            }
            if (numbers.any { it !in 1..45 }) {
                throw IllegalArgumentException("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자로 입력해야 합니다.")
            }
            return numbers
        } catch (e: NumberFormatException) {
            println("[ERROR] 로또 당첨 번호는 숫자로 입력해야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
//당첨번호 입력 및 유효성 검사
fun inputBonusNumber(): String {
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine()
}
//보너스 번호 입력 받기
fun getValidBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
        val input = inputBonusNumber()
        try {
            val bonusNumber = input.toInt()
            if (bonusNumber !in 1..45) {
                throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자로 입력해야 합니다.")
            }
            if (bonusNumber in winningNumbers) {
                throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다.")
            }
            return bonusNumber
        } catch (e: NumberFormatException) {
            println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
//보너스 번호 입력 및 유효성 검사