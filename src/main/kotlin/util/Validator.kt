package util

import util.Constants.MAX_LOTTO_RANGE
import util.Constants.MAX_PURCHASE_MONEY
import util.Constants.MIN_LOTTO_RANGE
import util.Constants.MIN_PURCHASE_MONEY
import util.Constants.MSG_ERR_BONUS_NOT_DUPLICATE
import util.Constants.MSG_ERR_DIVISIBLE_BY_THOUSAND
import util.Constants.MSG_ERR_INVALIDATE_INPUT
import util.Constants.MSG_ERR_LOTTO_NUMBER_RANGE
import util.Constants.MSG_ERR_ONLY_DIGIT
import util.Constants.MSG_ERR_PURCHASE_RANGE
import util.Constants.MSG_ERR_SIX_DISTINCT_NUMBER
import util.Constants.PROPER_LOTTO_SIZE

object Validator {

    fun checkIsDigit(input: String): Validator {
        require(input.all { it.isDigit() }) { MSG_ERR_ONLY_DIGIT }

        return this
    }

    fun checkIsEmptyString(input: String): Validator {
        require(input.isNotEmpty()) { MSG_ERR_INVALIDATE_INPUT }

        return this
    }

    fun checkPurchaseRange(money: Int): Validator {
        require(money in MIN_PURCHASE_MONEY..MAX_PURCHASE_MONEY) { MSG_ERR_PURCHASE_RANGE }

        return this
    }

    fun checkIsDivisibleByThousand(money: Int): Validator {
        require(
            money >= 1000 &&
                    money % 1000 == 0
        ) { MSG_ERR_DIVISIBLE_BY_THOUSAND }

        return this
    }

    fun checkProperNumbersSize(numbers: List<Int>): Validator {
        require(
            numbers.distinct()
                .size == PROPER_LOTTO_SIZE
        ) { MSG_ERR_SIX_DISTINCT_NUMBER }

        return this
    }

    fun checkNumberListInRange(numbers: List<Int>): Validator {
        for (number in numbers) checkNumberInRange(number)

        return this
    }

    fun checkNumberInRange(number: Int): Validator {
        require(number in MIN_LOTTO_RANGE..MAX_LOTTO_RANGE) { MSG_ERR_LOTTO_NUMBER_RANGE }

        return this
    }

    fun checkIsDuplicateNumber(number: Int, duplicateNumbers: List<Int>):Validator {
        require(!(duplicateNumbers.contains(number))) { MSG_ERR_BONUS_NOT_DUPLICATE }

        return this
    }
}