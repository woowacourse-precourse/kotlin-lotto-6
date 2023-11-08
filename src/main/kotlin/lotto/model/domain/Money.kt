package lotto.model.domain

class Money(val amount: Int) {
    init {
        requireMultiple(amount)
        requirePositive(amount)
    }

    private fun requireMultiple(money: Int) {
        if (money % 1000 != 0) {
            throw IllegalArgumentException(IS_NOT_MULTIPLE)
        }
    }

    private fun requirePositive(money: Int) {
        if (money <= 0) {
            throw IllegalArgumentException(IS_NOT_POSITIVE)
        }
    }

    companion object {
        const val IS_NOT_MULTIPLE = "금액은 1000 단위로 입력해 주세요"
        const val IS_NOT_POSITIVE = "금액은 0보다 크게 입력해 주세요"
    }
}