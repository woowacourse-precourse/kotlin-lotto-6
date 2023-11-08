package lotto.domain

import lotto.exception.MoneyException

class Money(val amount: Int) {
    init {
        require(amount >= 0) { MoneyException.NOT_POSITIVE_NUMBER.message }
    }

    override fun toString(): String = "%,d$UNIT_SUFFIX".format(amount)

    companion object {
        private const val UNIT_SUFFIX = "원"
    }
}