package lotto.io.input

import lotto.constants.Exception

class InputValidator {
    fun checkPurchaseAmount(purchaseAmount: String): Boolean {
        try {
            checkEmpty(purchaseAmount)
            checkNotDigit(purchaseAmount)
            checkNotDivisible(purchaseAmount, PURCHASE_AMOUNT_UNIT)
        } catch (e: IllegalArgumentException) {
            println(e)
            return false
        }
        return true
    }

    private fun checkEmpty(value: String) {
        require(value.isNotEmpty()) { Exception.EMPTY }
    }

    private fun checkNotDigit(value: String) {
        require(value.all { it.isDigit() }) { Exception.DIGIT }
    }

    private fun checkNotDivisible(value: String, unit: Int) {
        require(value.toInt() % unit == 0) { Exception.DIVISIBLE }
    }

    companion object {
        private const val PURCHASE_AMOUNT_UNIT = 1000
    }
}