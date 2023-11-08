package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    try {
        val purchaseAmount = getValidPurchaseAmount()
        val purchasedTickets = generateLottoTickets(purchaseAmount)
        println("${purchasedTickets}개를 구매했습니다.")

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun getValidPurchaseAmount(): Int { // 로또 구입 금액 및 유효성 검사
    try {
        val input = Console.readLine()
        val purchaseAmount = input.toInt()

        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.")
        }

        return purchaseAmount
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효하지 않은 숫자를 입력했습니다. 다시 입력하세요.")
    }
    return 0
}

fun generateLottoTickets(purchaseAmount: Int): Int {
    return purchaseAmount / 1000
}

fun getWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    while (true) {
        try {
            val input = Console.readLine()
            val numbers = input.split(",").map { it.trim().toInt() }

            if (numbers.size != 6 || numbers.any { it < 1 || it > 45 }) {
                println("[ERROR] 1에서 45 사이의 6개 번호를 중복되지 않게 입력해야 합니다.")
            } else if (numbers.toSet().size != 6) {
                println("[ERROR] 중복된 번호가 있습니다. 중복되지 않은 번호 6개를 입력해야 합니다.")
            } else {
                return numbers
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효하지 않은 숫자를 입력했습니다. 다시 입력하세요.")
        }
    }
}
fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    try {
        val input = Console.readLine()
        val bonusNumber = input.toInt()
        if (bonusNumber < 1 || bonusNumber > 45) {
            println("[ERROR] 1에서 45 사이의 번호를 입력하세요.")
        } else {
            return bonusNumber
        }
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효하지 않은 숫자를 입력했습니다. 다시 입력하세요.")
    }
    return 0
}