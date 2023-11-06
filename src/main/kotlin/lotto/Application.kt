package lotto

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    val purchaseAmount = getValidPurchaseAmount()
    val tickets = buyLottoTickets(purchaseAmount)
    tickets.forEach { println(it) }
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