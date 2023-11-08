package lotto

import lotto.Constants.ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE
import lotto.Constants.ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE
import lotto.Constants.ERROR_EMPTY_WINNING_NUMBER_MESSAGE
import lotto.Constants.ERROR_INVALID_LOTTO_AMOUNT_1000_EXCEPTION_MESSAGE
import lotto.Constants.ERROR_INVALID_NOT_NUMBER_LOTTO_AMOUNT_MESSAGE
import lotto.Constants.ERROR_INVALID_NUMBER_COUNT_MESSAGE
import lotto.Constants.ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE
import lotto.Constants.ERROR_OUT_OF_RANGE_NUMBER_MESSAGE
import lotto.Constants.LOTTO_PRICE
import lotto.Constants.MAX_LOTTO_NUMBER
import lotto.Constants.MAX_NUMBER
import lotto.Constants.MIN_LOTTO_NUMBER
import lotto.Constants.MIN_NUMBER

class Validator {

    fun isUserPurchaseAmountCheck(purchaseAmount: String) {
        checkForEmptyNumber(purchaseAmount)
        checkForNumeric(purchaseAmount)
        checkForDivisibilityBy1000(purchaseAmount)
    }

    fun isUserWinningNumbersCheck(winningNumbers: List<Int>) {
        checkForCountWinningNumbers(winningNumbers)
        checkForOutOfRangeWinningNumbers(winningNumbers)
        checkForDuplicateLottoNumbers(winningNumbers)
    }

    fun isUserBonusNumberCheck(lotto: List<Int>, bonus: String) {
        checkForEmptyNumber(bonus)
        checkForNumericBonus(bonus)
        checkForLottoAndBonusDuplicates(lotto, bonus)
        checkForPositiveBonusNumber(bonus)
        checkForOutOfRangeBonusNumber(bonus)
    }

    private fun checkForEmptyNumber(purchaseAmount: String) {
        if (isEmptyNumber(purchaseAmount)) {
            println(ERROR_EMPTY_WINNING_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForNumeric(purchaseAmount: String) {
        if (isNumeric(purchaseAmount)) {
            println(ERROR_INVALID_NOT_NUMBER_LOTTO_AMOUNT_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForDivisibilityBy1000(purchaseAmount: String) {
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

    private fun checkForCountWinningNumbers(winningNumbers: List<Int>) {
        if (isCountWinningNumbers(winningNumbers)) {
            println(ERROR_INVALID_NUMBER_COUNT_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForOutOfRangeWinningNumbers(winningNumbers: List<Int>) {
        if (isOutOfRangeWinningNumbers(winningNumbers)) {
            println(ERROR_OUT_OF_RANGE_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForDuplicateLottoNumbers(winningNumbers: List<Int>) {
        if (isDuplicateLottoNumbers(winningNumbers)) {
            println(ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun isCountWinningNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.size > MAX_NUMBER || winningNumbers.size < MAX_NUMBER
    }

    private fun isOutOfRangeWinningNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.any { it < MIN_LOTTO_NUMBER || it > MAX_LOTTO_NUMBER }
    }

    private fun isDuplicateLottoNumbers(winningNumbers: List<Int>): Boolean {
        return winningNumbers.size != winningNumbers.toSet().size
    }

    private fun checkForNumericBonus(bonus: String) {
        if (isNumeric(bonus)) {
            println(ERROR_INVALID_NOT_NUMBER_LOTTO_AMOUNT_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForLottoAndBonusDuplicates(lotto: List<Int>, bonus: String) {
        if (isLottoAndBonusDuplicates(lotto, bonus)) {
            println(ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForPositiveBonusNumber(bonus: String) {
        if (isPositiveBonusNumber(bonus)) {
            println(ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    private fun checkForOutOfRangeBonusNumber(bonus: String) {
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