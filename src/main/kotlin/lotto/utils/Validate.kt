package lotto.utils

import lotto.utils.Constants.ERROR_INPUT_BLANK
import lotto.utils.Constants.ERROR_INPUT_CHAR
import lotto.utils.Constants.ERROR_INPUT_DUPLICATE
import lotto.utils.Constants.ERROR_INPUT_RANGE
import lotto.utils.Constants.ERROR_INPUT_SIZE
import lotto.utils.Constants.LOTTO_NUMBER_SIZE
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import lotto.utils.Constants.MIN_LOTTO_NUMBER

object Validate {
    /* 구입 금액 입력 예외 처리 */
    fun validatePay(payment: Int) {
        requirePaymentUnit(payment)
        requirePaymentMinimum(payment)
        requirePaymentMaximum(payment)
    }

    private fun requirePaymentUnit(payment: Int) {
        require(payment % Constants.LOTTO_PURCHASE_UNIT == Constants.INITIALIZE_NUMBER) { Constants.ERROR_PAY_INPUT_UNIT }
    }

    private fun requirePaymentMinimum(payment: Int) {
        require(payment >= Constants.LOTTO_PURCHASE_UNIT) { Constants.ERROR_PAY_INPUT_MINIMUM }
    }

    private fun requirePaymentMaximum(payment: Int) {
        require(payment <= (Constants.LOTTO_PURCHASE_UNIT * Constants.MAX_PURCHASE_PIECE)) { Constants.ERROR_PAY_INPUT_MAXIMUM }
    }

    /* 당첨 번호 입력 예외 처리 */
    fun validateWinningNumber(newWinningNumber: String) {
        val splitWinningNumbers = newWinningNumber.split(",").map { it.trim() }
        requireWinningNumbersNotBlank(splitWinningNumbers)
        requireWinningNumbersOnlyDigits(splitWinningNumbers)
        requireWinningNumbersSize(splitWinningNumbers)
        requireWinningNumbersNoDuplicates(splitWinningNumbers)
        requireWinningNumbersRange(splitWinningNumbers)
    }

    private fun requireWinningNumbersNotBlank(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.none { it.isBlank() }) { ERROR_INPUT_BLANK }
    }

    private fun requireWinningNumbersOnlyDigits(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.all { it.toIntOrNull() != null }) { ERROR_INPUT_CHAR }
    }

    private fun requireWinningNumbersSize(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_SIZE }
    }

    private fun requireWinningNumbersNoDuplicates(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.distinct().size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_DUPLICATE }
    }

    private fun requireWinningNumbersRange(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.all { it.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_INPUT_RANGE }
    }

    /* 보너스 번호 입력 예외 처리 */
    fun validateBonusNumber(newBonusNumber: Int, winningNumbers: List<Int>) {
        requireBonusNumberRange(newBonusNumber)
        requireBonusNumberDuplicate(newBonusNumber, winningNumbers)
    }

    private fun requireBonusNumberRange(newBonusNumber: Int) {
        require(newBonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { ERROR_INPUT_RANGE }
    }

    private fun requireBonusNumberDuplicate(newBonusNumber: Int, winningNumbers: List<Int>) {
        require(newBonusNumber !in winningNumbers) { Constants.ERROR_INPUT_DUPLICATE }
    }
}