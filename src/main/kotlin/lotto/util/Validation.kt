package lotto.util

import lotto.util.Constants.DUPLICATE_ERROR
import lotto.util.Constants.DUPLICATE_WITH_LOTTO_ERROR
import lotto.util.Constants.INPUT_BLANK_OR_STRING_ERROR
import lotto.util.Constants.INPUT_WRONG_LENGTH_ERROR
import lotto.util.Constants.INPUT_WRONG_RANGE_ERROR
import lotto.util.Constants.INPUT_WRONG_UNIT_ERROR
import lotto.util.Constants.UNIT

object Validation {

    fun validatePurchaseAmount(amount: String) {

        require(amount.toIntOrNull() != null)
        { INPUT_BLANK_OR_STRING_ERROR }

        require((amount.toInt() % UNIT == 0) && (amount.toInt() > 0))
        { INPUT_WRONG_UNIT_ERROR }

    }

    fun validateDuplicateNumbers(lottoNumbers: List<Int>): Boolean {

        val lottoCheck = HashSet<Int>()
        for (number in lottoNumbers) {
            if (lottoCheck.contains(number)) {
                return true
            }
            lottoCheck.add(number)
        }
        return false
    }

    fun validateWinningNumbers(winningNumbers: List<String>) {

        require(winningNumbers.all { it.toIntOrNull() != null })
        { INPUT_BLANK_OR_STRING_ERROR }

        require(winningNumbers.size == 6)
        { INPUT_WRONG_LENGTH_ERROR }

        require(winningNumbers.all { it.toInt() in 1..45 })
        { INPUT_WRONG_RANGE_ERROR }

        require(!validateDuplicateNumbers(winningNumbers.map { it.toInt() }))
        { DUPLICATE_ERROR }
    }

    fun validateBonusNumber(winningNumbers: List<Int>, bonusNumber: String) {
        require(bonusNumber.toIntOrNull() != null)
        { INPUT_BLANK_OR_STRING_ERROR }

        require(bonusNumber.toInt() in 1..45)
        { INPUT_WRONG_RANGE_ERROR }

        require(!winningNumbers.contains(bonusNumber.toInt()))
        { DUPLICATE_WITH_LOTTO_ERROR }
    }

}