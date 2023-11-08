package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    try {
        val purchaseAmount = getValidPurchaseAmount()
        val purchasedTickets = generateLottoTickets(purchaseAmount)
        println("${purchasedTickets}개를 구매했습니다.")
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