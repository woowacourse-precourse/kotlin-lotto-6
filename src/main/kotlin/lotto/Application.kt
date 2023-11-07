package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    println("구입금액을 입력해 주세요.")
    val purchaseAmount = readPurchaseAmount()
    println()

    val myPurchaselottos = purchaseLottos(purchaseAmount)
    println()

    val winningNumbers = readWinningNumbers()
    println()

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = readBonusNumber(winningNumbers)
    println()

    val results = compareLottosWithWinningNumbers(myPurchaselottos, winningNumbers, bonusNumber)
    printResults(results, myPurchaselottos.size)
}

fun readPurchaseAmount(): Int {
    while (true) {
        try {
            val input = Console.readLine().toInt()
            if (input % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 유효한 금액을 입력하세요.")
            }
            return input
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효한 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun purchaseLottos(purchaseAmount: Int): List<Lotto> {
    val numberOfLottos = purchaseAmount / 1000
    val myPurchaselottos = mutableListOf<Lotto>()
    for (i in 1..numberOfLottos) {
        myPurchaselottos.add(Lotto.createRandomLotto())
    }
    println("${numberOfLottos}개를 구매했습니다.")
    myPurchaselottos.forEach { lotto ->
        println(lotto.getNumbers().sorted())
    }
    return myPurchaselottos
}

fun readWinningNumbers(): List<Int> {
    return readNumbers("당첨 번호")
}

fun readNumbers(message: String): List<Int> {
    while (true) {
        try {
            println("${message}를 입력해 주세요.")
            val input = Console.readLine()
            val numbers = input.split(",").map { it.trim().toInt() }

            if (numbers.size != 6 || numbers.any { it !in 1..45 } || numbers.toSet().size < 6) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 6개이며, 1부터 45 사이의 서로 다른 숫자여야 합니다.")
            }
            return numbers
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효한 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
        try {
            val bonusNumber = Console.readLine().toInt()
            if (bonusNumber !in 1..45) {
                throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
            if (bonusNumber in winningNumbers) {
                throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
            }
            return bonusNumber
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효한 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun compareLottosWithWinningNumbers(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Prize> {
    val results = mutableListOf<Prize>()
    for (lotto in lottos) {
        val matchedNumbers = lotto.getNumbers().intersect(winningNumbers).count()
        val matchedBonus = lotto.contains(bonusNumber)
        val prize = Prize.values().find { it.matchedNumbers == matchedNumbers && matchedBonus } ?: Prize.values().find { it.matchedNumbers == matchedNumbers }
        results.add(prize ?: Prize.NONE)
    }
    return results
}

fun calculatePrizeMoney(results: List<Prize>): List<Int> {
    return results.map { it.calculatePrizeMoney() }
}

fun printResults(results: List<Prize>, numberOfPurchasedLottos: Int) {
    println("당첨 통계")
    println("---")
    val prizeGroups = results.groupBy { it }
    for (prize in Prize.values()) {
        val count = prizeGroups[prize]?.size ?: 0
        if (prize != Prize.NONE) {
            println("${prize} - ${count}개")
        }
    }
    val totalPrizeMoney = calculatePrizeMoney(results).sum()
    val totalPrizeRate = (totalPrizeMoney.toDouble() / (numberOfPurchasedLottos * 1000)) * 100
    println("총 수익률은 ${"%.1f".format(totalPrizeRate)}%입니다.")
}