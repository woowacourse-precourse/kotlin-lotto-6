package lotto

import lotto.Constants.Companion.ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE
import lotto.Constants.Companion.ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE
import lotto.Constants.Companion.ERROR_EMPTY_WINNING_NUMBER_MESSAGE
import lotto.Constants.Companion.ERROR_INVALID_LOTTO_AMOUNT_1000_EXCEPTION_MESSAGE
import lotto.Constants.Companion.ERROR_INVALID_NOT_NUMBER_LOTTO_AMOUNT_MESSAGE
import lotto.Constants.Companion.ERROR_INVALID_NUMBER_COUNT_MESSAGE
import lotto.Constants.Companion.ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE
import lotto.Constants.Companion.ERROR_OUT_OF_RANGE_NUMBER_MESSAGE
import lotto.Constants.Companion.LOTTO_PRICE
import lotto.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.Constants.Companion.MAX_NUMBER
import lotto.Constants.Companion.MIN_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_NUMBER

class Validator {

    fun isUserPurchaseAmountCheck(purchaseAmount: String) {
        if (isEmptyNumber(purchaseAmount)) {
            println(ERROR_EMPTY_WINNING_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isNumeric(purchaseAmount)) {
            println(ERROR_INVALID_NOT_NUMBER_LOTTO_AMOUNT_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isDivisibleBy1000(purchaseAmount)) {
            println(ERROR_INVALID_LOTTO_AMOUNT_1000_EXCEPTION_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun isDivisibleBy1000(purchaseAmount: String): Boolean {
        return purchaseAmount.toInt() % LOTTO_PRICE != MIN_NUMBER
    }

    private fun isNumeric(number: String): Boolean {
        return number.toIntOrNull() == null
    }

    fun isUserWinningNumbersCheck(winningNumbers: List<Int>) {
        if (isEmptyWinningNumbers(winningNumbers)) {
            println(ERROR_EMPTY_WINNING_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isTooManyWinningNumbers(winningNumbers)) {
            println(ERROR_INVALID_NUMBER_COUNT_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isOutOfRangeWinningNumbers(winningNumbers)) {
            println(ERROR_OUT_OF_RANGE_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isDuplicateLottoNumbers(winningNumbers)) {
            println(ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isPositiveWinningNumbers(winningNumbers)) {
            println(ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun isTooManyWinningNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.size > MAX_NUMBER
    }

    private fun isOutOfRangeWinningNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.any { it < MIN_LOTTO_NUMBER || it > MAX_LOTTO_NUMBER }
    }

    private fun isDuplicateLottoNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.size != winningNumbers.toSet().size
    }

    private fun isPositiveWinningNumbers(winningNumbers: List<Int>): Boolean {
        return !winningNumbers.all { it > 0 }
    }

    private fun isEmptyWinningNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.isEmpty()
    }

    fun isUserBonusNumberCheck(lotto: List<Int>, bonus: String) {
        if (isEmptyNumber(bonus)) {
            println(ERROR_EMPTY_WINNING_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isNumeric(bonus)) {
            println(ERROR_INVALID_NOT_NUMBER_LOTTO_AMOUNT_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isLottoAndBonusDuplicates(lotto, bonus)) {
            println(ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isPositiveBonusNumber(bonus)) {
            println(ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE)
            throw IllegalArgumentException()
        }
        if (isOutOfRangeBonusNumber(bonus)) {
            println(ERROR_OUT_OF_RANGE_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun isLottoAndBonusDuplicates(lotto: List<Int>, bonus: String): Boolean {
        return lotto.contains(bonus.toInt())
    }

    private fun isPositiveBonusNumber(bonus: String): Boolean {
        return bonus.toInt() < MIN_NUMBER
    }

    private fun isOutOfRangeBonusNumber(bonus: String): Boolean {
        return bonus.toInt() < MIN_LOTTO_NUMBER || bonus.toInt() > MAX_LOTTO_NUMBER
    }

    private fun isEmptyNumber(bonus: String): Boolean {
        return bonus.isEmpty()
    }

}