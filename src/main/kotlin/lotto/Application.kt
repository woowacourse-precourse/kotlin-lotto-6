import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

import lotto.Lotto
import lotto.Prize

fun main() {
    val purchaseAmount = getPurchaseAmount()
    val lottos = generateLotto(purchaseAmount)

    val winningNumbers = getWinningNumbers()
    val bonusNumber = getBonusNumber()

    val result = calculateResult(lottos, winningNumbers, bonusNumber)

    printResult(result)
}

fun getPurchaseAmount(): Int {
    while (true) {
        println("구입 금액을 입력해 주세요.")
        val amount = Console.readLine().toInt()
        if (amount % 1000 == 0) {
            return amount
        }
        else {
            throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.")
        }
    }
}

fun generateLotto(purchaseAmount: Int): List<Lotto> {
    val numberOflottos = purchaseAmount / 1000
    val lottos = mutableListOf<Lotto>()

    repeat(numberOflottos) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lotto = Lotto(numbers)
        lottos.add(lotto)
    }

    println("\n${lottos.size}개를 구매했습니다.")
    lottos.forEach { lotto ->
        println(lotto.getSortedNumbers())
    }

    return lottos
}

fun getWinningNumbers(): List<Int> {
    while (true) {
        println("\n당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.toInt() }
        if (numbers.size == 6 && numbers.all { it in 1..45 }) {
            return numbers
        } else {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}

fun getBonusNumber(): Int {
    while (true) {
        println("\n보너스 번호를 입력해 주세요.")
        val number = Console.readLine().toInt()
        if (number in 1..45) {
            return number
        }
        else {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}

fun calculateResult(
    lottos: List<Lotto>,
    winningNumbers: List<Int>,
    bonusNumber: Int
): Map<Prize, Int> {
    val result = mutableMapOf<Prize, Int>().withDefault { 0 }

    for (lotto in lottos) {
        val rank = lotto.matchWith(winningNumbers, bonusNumber)
        result[rank] = result.getValue(rank) + 1
    }

    return result
}

fun printResult(result: Map<Prize, Int>) {
    println("\n당첨 통계")
    println("---")
    Prize.entries.dropLast(1).forEach { rank ->
        val count = result.getValue(rank)
        val prize = rank.prize
        if (prize.toInt() == 30_000_000) {
            println("${rank.matchCount}개 일치, 보너스 볼 일치 (${prize.formatCurrency()}) - ${count}개")
        }
        else {
            println("${rank.matchCount}개 일치 (${prize.formatCurrency()}) - ${count}개")
        }
    }
    println("총 수익률은 ${calculateTotalProfitRate(result)}%입니다.")
}

fun Long.formatCurrency(): String {
    return String.format("%,d원", this)
}

fun calculateTotalProfitRate(result: Map<Prize, Int>): Double {
    val totalSpent = result.values.sum() * 1000
    val totalPrize = result.map { it.key.prize * it.value }.sum()
    
    return (totalPrize.toDouble() / totalSpent) * 100
}
