package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun getPurchaseAmount(): Int {
    try {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
        if (purchaseAmount <= 0) {
            throw IllegalArgumentException("구입 금액은 양수여야 합니다.")
        }
        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.")
        }
        return purchaseAmount
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
        return getPurchaseAmount()
    }
}

fun generateTicket(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun getWinningNumbers(): Lotto {
    while (true) {
        try {
            println("\n당첨 번호를 입력해 주세요.")
            val input = Console.readLine() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
            val numbers = input.split(',').map { it.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.") }
            validateNumbers(numbers)
            return Lotto(numbers)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun validateNumbers(numbers: List<Int>) {
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.")
    }
    if (numbers.size != 6) {
        throw IllegalArgumentException("로또 번호는 6개여야 합니다.")
    }
    if (numbers.distinct().size != 6) {
        throw IllegalArgumentException("로또 번호는 중복될 수 없습니다.")
    }
}