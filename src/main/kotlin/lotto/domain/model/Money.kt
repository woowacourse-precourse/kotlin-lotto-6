package lotto.domain.model

@JvmInline
value class Money(val amount: Int) {
    init {
        require(amount >= MIN_MONEY_AMOUNT) { MUST_GREATER_THAN_MIN_MONEY_MESSAGE }
        require(amount % DIVISION_AMOUNT == 0) { MUST_BE_DIVIDABLE_BY_DIVISION_AMOUNT_MESSAGE }
    }

    companion object {
        const val MIN_MONEY_AMOUNT = 1_000
        const val DIVISION_AMOUNT = 1_000
        const val MUST_GREATER_THAN_MIN_MONEY_MESSAGE = "${MIN_MONEY_AMOUNT}원 이상의 금액을 입력해주세요."
        const val MUST_BE_DIVIDABLE_BY_DIVISION_AMOUNT_MESSAGE = "금액이 ${DIVISION_AMOUNT}원으로 나누어 져야 합니다."
    }
}