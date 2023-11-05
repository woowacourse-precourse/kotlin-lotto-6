package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun validatePriceAmount(): String {
        println("구입금액을 입력해 주세요.")
        val priceAmount = Console.readLine()
        if (priceAmount.isEmpty()) {
            throw IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.")
        }
        return priceAmount
    }

    fun validatePriceInt(priceAmount: String): Int {
        return priceAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 정수를 입력해주세요.")
    }

    fun validatePriceRange(priceAmount: Int): Int {
        if (priceAmount < 1000) {
            throw IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해주세요.")
        }
        return priceAmount
    }

    fun validatePriceUnit(priceAmount: Int): Int {
        if (priceAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
        }
        return priceAmount
    }

    fun calculateCount(priceAmount: Int): Int {
        println("${priceAmount / 1000}개를 구매했습니다.")
        return priceAmount / 1000
    }
}