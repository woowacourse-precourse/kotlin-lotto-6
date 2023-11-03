package lotto.domain

import lotto.exception.MoneyException

class Money(private val money: Int) {

    companion object {
        private const val DIVISOR = 1000
    }

    init {
        checkDivisibleByDivisor(money)
        checkGreaterThanOrEqualDivisor(money)
    }

    private fun checkDivisibleByDivisor(input: Int) =
        require(input % DIVISOR == 0) { MoneyException.NOT_DIVISIBLE.getDivisor(DIVISOR) }
    private fun checkGreaterThanOrEqualDivisor(input: Int) =
        require(input >= DIVISOR) { MoneyException.LESS_THAN_DIVISOR.getDivisor(DIVISOR) }
}