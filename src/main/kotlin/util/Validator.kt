package util

import util.Constants.MAX_PURCHASE_MONEY
import util.Constants.MIN_PURCHASE_MONEY

object Validator {

    fun checkIsDigit(input: String): Validator {
        require(input.all{ it.isDigit() })
        return this
    }

    fun checkIsEmptyString(input: String): Validator {
        require(input.isNotEmpty())
        return this
    }

    fun checkPurchaseRange(money: Int): Validator {
        require(money in MIN_PURCHASE_MONEY..MAX_PURCHASE_MONEY)
        return this
    }

    fun checkProperNumbersSize(numbers: List<Int>) =
        require(
            numbers.distinct()
                .size == 6
        )
}