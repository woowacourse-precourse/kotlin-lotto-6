package lotto.domain

object PurchaseAmount {

    private val THOUSAND = 1000
    private val ZERO = 0

    fun validators(amount: String): Int {
        purchaseAmountEmpty(amount)
        purchaseAmountNotInt(amount)
        NonDivisibleAmount(amount.toInt())
        return amount.toInt()
    }

    fun purchaseAmountEmpty(num: String) {
        require (num.isNotEmpty() && num.isNotBlank()) {Number.EMPTY}
    }

    fun purchaseAmountNotInt(num: String) {
        require (num.all { it.isDigit() }) {Number.NON_INTEGER}
    }

    fun NonDivisibleAmount(num: Int) {
        require (num % THOUSAND == ZERO) {"[ERROR] 1,000원 단위로 입력해주세요."}
    }
}

