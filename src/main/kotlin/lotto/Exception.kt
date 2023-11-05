package lotto

object Exception {

    fun purchaseAmountEntryException(input: String?): Int? {
        if (input.isNullOrEmpty() || !input.all { it.isDigit() }) {
            throw IllegalArgumentException("[ERROR] 올바른 값을 입력해 주세요.")
        }
        val amount = input.toInt()
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액을 1,000원 단위로 입력해 주세요.")
        }
        return amount
    }
}