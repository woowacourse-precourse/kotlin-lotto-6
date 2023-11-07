package lotto

import camp.nextstep.edu.missionutils.Console

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