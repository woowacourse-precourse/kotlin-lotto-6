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

