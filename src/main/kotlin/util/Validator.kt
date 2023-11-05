package util

import util.Constants.MAX_LOTTO_RANGE
import util.Constants.MAX_PURCHASE_MONEY
import util.Constants.MIN_LOTTO_RANGE
import util.Constants.MIN_PURCHASE_MONEY
import util.Constants.PROPER_LOTTO_SIZE

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

    fun checkProperNumbersSize(numbers: List<Int>): Validator {
        require(
            numbers.distinct()
                .size == PROPER_LOTTO_SIZE
        )
        return this
    }

    fun checkNumbersInRange(numbers: List<Int>): Validator {
        require(numbers.all { it in MIN_LOTTO_RANGE..MAX_LOTTO_RANGE })
        return this
    }

}