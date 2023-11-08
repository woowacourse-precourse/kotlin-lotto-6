package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    val purchaseAmount = getPurchaseAmount()
    val lottoTickets = generateLottoNumbers(purchaseAmount)

    println("")
    println("${lottoTickets.size}개를 구매했습니다.")
    for (ticket in lottoTickets) {
        println("[${ticket.getNumbers().joinToString(", ")}]")
    }

    println("")
    val winningNumbers = getWinningNumbers()

    println("")
    val bonusNumber = getBonusNumber()

    val sumResults = sumResults(lottoTickets, winningNumbers, bonusNumber)

    println("\n당첨 통계")
    println("---")
    for ((key, value) in sumResults) {
        println("$key - ${value}개")
    }

    val sumTotalEarningsRate = sumTotalEarningsRate(purchaseAmount, sumResults)
    println("\n총 수익률은 ${String.format("%.1f", sumTotalEarningsRate)}%입니다.")
}

fun generateLottoNumbers(purchaseAmount: Int): List<Lotto> {
    val lottoNumbers = mutableListOf<Lotto>()
    for (i in 1..(purchaseAmount / 1000)) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lotto = Lotto(numbers)
        lottoNumbers.add(lotto)
    }
    return lottoNumbers
}

fun getPurchaseAmount(): Int {
    var amount = 1
    while (amount % 1000 != 0) {
        amount = inputPurchase(amount)
    }
    return amount
}

fun inputPurchase(amount: Int): Int {
    var confirmAmount = amount
    try {
        confirmAmount = Console.readLine()?.toInt()!!
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
        return amount
    }
    if (confirmAmount % 1000 != 0) {
        println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.")
        return amount
    }
    if (confirmAmount == 0) {
        println("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.")
        return amount
    }
    return confirmAmount
}

fun getWinningNumbers(): List<Int> {
    var numbers = listOf(0)
    println("당첨 번호를 입력해 주세요.")
    while (numbers == listOf(0)) {
        numbers = inputWinningNumbers()
    }
    return numbers
}

fun inputWinningNumbers(): List<Int> {
    try {
        val numbers: List<Int>
        val input = Console.readLine()
        numbers = input?.split(",")!!.mapNotNull { it.trim().toIntOrNull() }
        validateLottoNumbers(numbers)
        return numbers
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return listOf(0)
}

fun getBonusNumber(): Int {
    var number = 0
    println("보너스 번호를 입력해 주세요.")
    while (number < 1 || number > 45) {
        number = inputBonusNumbers()
    }
    return number
}

fun inputBonusNumbers(): Int {
    var result = 0
    try {
        result = Console.readLine()!!.toInt()
        validateBonusNumbers(result)
        return result
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return result
}

fun validateLottoNumbers(numbers: List<Int>) {
    if (numbers == null || numbers.size != 6 || numbers.any { it < 1 || it > 45 } || numbers.size != numbers.distinct().size) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자 6개를 입력해야 하며 중복이 없어야 합니다.")
    }
}

fun validateBonusNumbers(number: Int) {
    if (number < 1 || number > 45) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

fun sumResults(lottoNumbers: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): MutableMap<String, Int> {
    var results = mutableMapOf(
        "3개 일치 (5,000원)" to 0,
        "4개 일치 (50,000원)" to 0,
        "5개 일치 (1,500,000원)" to 0,
        "5개 일치, 보너스 볼 일치 (30,000,000원)" to 0,
        "6개 일치 (2,000,000,000원)" to 0)

    for (lotto in lottoNumbers) {
        val numbers = lotto.getNumbers()
        results = numberMatching(results, numbers, winningNumbers, bonusNumber)
    }
    return results
}

fun numberMatching(results: MutableMap<String, Int>, numbers: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): MutableMap<String, Int> {
    val numbersMatching = numbers.intersect(winningNumbers.toSet()).toList()
    val bonusMatching = if (numbers.contains(bonusNumber)) 1 else 0

    when (numbersMatching.size) {
        6 -> results["6개 일치 (2,000,000,000원)"] = results["6개 일치 (2,000,000,000원)"]!! + 1
        5 -> results["5개 일치 (1,500,000원)"] = results["5개 일치 (1,500,000원)"]!! + 1
        4 -> results["4개 일치 (50,000원)"] = results["4개 일치 (50,000원)"]!! + 1
        3 -> results["3개 일치 (5,000원)"] = results["3개 일치 (5,000원)"]!! + 1
    }

    if (numbersMatching.size == 5 && bonusMatching == 1) {
        results["5개 일치, 보너스 볼 일치 (30,000,000원)"] = results["5개 일치, 보너스 볼 일치 (30,000,000원)"]!! + 1
    }
    return results
}

fun sumMoney(entry: Map.Entry<String, Int>): Int {
    return when (entry.key) {
        "6개 일치 (2,000,000,000원)" -> entry.value * 2_000_000_000
        "5개 일치, 보너스 볼 일치 (30,000,000원)" -> entry.value * 30_000_000
        "5개 일치 (1,500,000원)" -> entry.value * 1_500_000
        "4개 일치 (50,000원)" -> entry.value * 50_000
        "3개 일치 (5,000원)" -> entry.value * 5_000
        else -> 0
    }
}

fun sumTotalEarningsRate(purchaseAmount: Int, results: Map<String, Int>): Double {
    val totalEarningsAmount = results.entries.sumOf { entry ->
        sumMoney(entry)
    }

    return (totalEarningsAmount.toDouble() / purchaseAmount) * 100.0
}