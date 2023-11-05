package model

class Money(private val price: String) {
    init {
        require(price.all { it.isDigit() }) { Error.INPUT_ONLY_NUMBER.message }
        require(price.isNotBlank()) { Error.PURCHASE_AMOUNT_EMPTY.message }
        require(price.first() != '0') { Error.NUMBER_FORMAT.message }
        require(price.toInt() % 1000 == 0) { Error.PURCHASE_IN_THOUSAND_WON.message }
        require(price.toInt() <= 100_000) { Error.AMOUNT_OVER_MAX_LIMIT.message }
    }

    fun getPurchasableLottoTicketCount() = price.toInt() / 1000

    private enum class Error(val message: String) {
        INPUT_ONLY_NUMBER("[ERROR] 숫자만 입력이 가능합니다."),
        PURCHASE_AMOUNT_EMPTY("[ERROR] 구매 금액이 입력되지 않았습니다."),
        NUMBER_FORMAT("[ERROR] 올바른 숫자 형태가 아닙니다."),
        PURCHASE_IN_THOUSAND_WON("[ERROR] 1,000원 단위로 구매가 가능합니다."),
        AMOUNT_OVER_MAX_LIMIT("[ERROR] 최대 100,000원 까지 구매가 가능합니다."),
    }
}
