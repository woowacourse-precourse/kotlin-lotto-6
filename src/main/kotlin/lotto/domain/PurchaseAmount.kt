package lotto.domain

import lotto.Constants.MONETARY_UNIT
import lotto.Constants.ZERO


enum class PurchaseAmount(val message: String) {
    THOUSAN("[ERROR] 1,000원 단위로 입력해주세요.")
}

fun purchaseAmountValidators(amount: String): Int {
    purchaseAmountEmpty(amount)
    purchaseAmountNotInt(amount)
    nonDivisibleAmount(amount.toInt())
    return amount.toInt()
}

fun purchaseAmountEmpty(num: String) {
    require (num.isNotEmpty() && num.isNotBlank()) { Number.EMPTY.message }
}

fun purchaseAmountNotInt(num: String) {
    require (num.all { it.isDigit() }) { Number.NON_INTEGER.message }
}

fun nonDivisibleAmount(num: Int) {
    require (num % MONETARY_UNIT == ZERO) { PurchaseAmount.THOUSAN.message }
}

