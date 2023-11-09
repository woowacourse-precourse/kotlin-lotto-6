package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class Prize(val description: String, val winningAmount: Long) {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    FIFTH("3개 일치 (5,000원)", 5_000),
    NO_PRIZE("꽝",0)
}

fun main() {
    println("구입금액을 입력해 주세요.")

    val purchaseAmount = getPurchaseAmount()

    val lottoNumbers = generateLottoNumbers(purchaseAmount)

    println("${lottoNumbers.size}개를 구매했습니다.")
    for (lottoNumber in lottoNumbers) {
        println(lottoNumber)
    }
    println("당첨 번호를 입력해 주세요.")
    val winningNumbers = getWinningNumbers()

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = getBonusNumber()

    val results = calculateResults(lottoNumbers, winningNumbers, bonusNumber)
    println("\n당첨 통계")
    println("---")
    for (prize in Prize.values()) {
        val count = results[prize]
        println("${prize.description} - ${count}개")
    }

    val totalProfitRate = calculateTotalProfitRate(purchaseAmount, results)
    println("\n총 수익률은 ${String.format("%.1f", totalProfitRate)}%입니다.")
}

fun generateLottoNumbers(purchaseAmount: Int): List<Lotto> {
    val lottoNumbers = mutableListOf<Lotto>()
    for (i in 1..(purchaseAmount / 1000)) {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
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
    var mutableAmount = amount
    try {
        mutableAmount = Console.readLine().toInt()!!
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
        return amount
    }
    if (mutableAmount % 1000 != 0 || mutableAmount == 0) {
        println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.")
        return amount
    }
    return mutableAmount
}

fun getWinningNumbers(): List<Int> {
    var numbers = listOf(0)
    while (numbers == listOf(0)) {
        numbers = inputWinningNumbers()
    }
    return numbers
}

fun inputWinningNumbers(): List<Int> {
    try {
        var numbers: List<Int>
        val input = Console.readLine()
        numbers = input?.split(",")!!.mapNotNull { it.trim().toIntOrNull() }
        validateLottoNumbers(numbers)
        return numbers ?: throw NumberFormatException("[ERROR] 잘못된 입력 형식입니다.")// 유효한 입력이 들어왔으면 루프를 종료
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return listOf(0)
}

fun validateLottoNumbers(numbers: List<Int>?) {
    if (numbers == null || numbers.size != 6 || numbers.any { it < 1 || it > 45 } || numbers.size != numbers.distinct().size) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자 6개를 입력해야 하며 중복이 없어야 합니다.")
    }
}

fun getBonusNumber(): Int {
    var number = 0
    while (number < 1 || number > 45) {
        number = inputBonusNumbers()
    }
    return number
}

fun inputBonusNumbers(): Int {
    var result = 0
    try {
        result = Console.readLine().toInt()
        validateBonusNumbers(result)
        return result
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return result
}

fun validateBonusNumbers(number: Int) {
    if (number < 1 || number > 45) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

fun calculateResults(lottoNumbers: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
    val results = mutableMapOf<Prize, Int>()
    for (prize in Prize.values()) {
        results[prize] = 0
    }
    for (lotto in lottoNumbers) {
        val numbers = lotto.getNumbers()
        val prize = determinePrize(numbers, winningNumbers, bonusNumber)
        results[prize] = results.getOrDefault(prize, 0) + 1
    }
    return results
}

fun determinePrize(numbers: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): Prize {
    val matchingNumbers = numbers.intersect(winningNumbers).toList()
    val bonusMatch = if (numbers.contains(bonusNumber)) 1 else 0

    return when (matchingNumbers.size) {
        6 -> Prize.FIRST
        5 -> if (bonusMatch == 1) Prize.SECOND else Prize.THIRD
        4 -> Prize.FOURTH
        3 -> Prize.FIFTH
        else -> Prize.NO_PRIZE
    }
}


fun calculateTotalProfitRate(purchaseAmount: Int, results: Map<Prize, Int>): Double {
    val totalWinningAmount = results.entries.sumByLong { entry ->
        entry.key.winningAmount * entry.value.toLong()
    }
    return (totalWinningAmount.toDouble() / purchaseAmount) * 100.0
}

inline fun <K, V> Iterable<Map.Entry<K, V>>.sumByLong(selector: (Map.Entry<K, V>) -> Long): Long {
    var sum: Long = 0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}
