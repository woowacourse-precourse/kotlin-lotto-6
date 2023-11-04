package lotto.domain

import lotto.exception.MoneyException

class Money(val amount: Int) {
    init {
        require(amount >= 0) { MoneyException.NOT_POSITIVE_NUMBER.message }
    }
}