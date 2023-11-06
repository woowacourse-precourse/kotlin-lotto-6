package lotto

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    val purchaseAmount = getValidPurchaseAmount()
    val tickets = buyLottoTickets(purchaseAmount)
    val winningNumbers = getValidWinningNumbers()
    val results = tickets.map { it.matchCount(winningNumbers) }
    results.forEach { println(it) }
}

fun buyLottoTickets(purchaseAmount: Int): List<Lotto> {
    val ticketCount = purchaseAmount / 1000
    return List(ticketCount) {
        val numbers = generateLottoNumbers()
        Lotto(numbers)
    }
}
fun inputPurchaseAmount(): String {
    println("구입금액을 입력해 주세요.")
    return readLine().orEmpty()
}

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

fun generateLottoNumbers(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}

fun inputWinningNumbers(): String {
    println("당첨 번호를 입력해 주세요.")
    return readLine().orEmpty()
}

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