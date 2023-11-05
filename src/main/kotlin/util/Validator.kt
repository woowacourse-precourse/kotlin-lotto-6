package util

object Validator {
    fun containsOnlyDigits(price: String) {
        require(price.all { it.isDigit() }) { Error.INPUT_ONLY_NUMBER.message }
    }

    fun isAmountInThousandWon(price: String) {
        require(price.toInt() % 1000 == 0) { Error.PURCHASE_IN_THOUSAND_WON.message }
    }

    fun isEmptyValue(price: String) {
        require(price.isNotBlank()) { Error.PURCHASE_AMOUNT_EMPTY.message }
    }

    private enum class Error(val message: String) {
        INPUT_ONLY_NUMBER("[ERROR] 숫자만 입력이 가능합니다."),
        PURCHASE_IN_THOUSAND_WON("[ERROR] 1,000원 단위로 구매가 가능합니다."),
        PURCHASE_AMOUNT_EMPTY("[ERROR] 구매 금액이 입력되지 않았습니다."),
    }
}
