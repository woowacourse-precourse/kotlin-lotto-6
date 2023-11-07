package lotto.domain

class PurchaseAmount() {

    fun validators(amount: String): Int {
        purchaseAmountEmpty(amount)
        purchaseAmountNotInt(amount)
        NonDivisibleAmount(amount.toInt())
        return amount.toInt()
    }
    // 로또 구매 금액이 공백인 경우
    fun purchaseAmountEmpty(num: String) {
        require (num.isNotEmpty() && num.isNotBlank()) {"[ERROR] 공백은 포함할 수 없습니다."}
    }

    // 로또 구매 금액이 정수가 아닌 경우
    fun purchaseAmountNotInt(num: String) {
        require (num.all { it.isDigit() }) {"[ERROR] 로또 금액은 정수로 입력해주세요."}
    }

    fun NonDivisibleAmount(num: Int) {
        require (num % 1000 == 0) {"[ERROR] 1,000원 단위로 입력해주세요."}
    }
}

