package lotto.util

import lotto.constants.LottoConstants
import lotto.constants.message.ExceptionMessage

object ValidationUtil {
    fun checkPurchaseAmount(purchaseAmount: String) {
        require(purchaseAmount.isNotBlank() && purchaseAmount.isNotEmpty()) { ExceptionMessage.INPUT_IS_BLANK }
        require(purchaseAmount.isDigit()) { ExceptionMessage.NOT_NUMBER }
        val amount = purchaseAmount.toInt()
        require(amount > 0 && amount % LottoConstants.THOUSAND_WON == 0) { ExceptionMessage.AMOUNT_MUST_BE_THOUSAND_WON }
        require(amount <= LottoConstants.MILLION_WON) { ExceptionMessage.AMOUNT_MUST_BE_UNDER_MILLION_WON }
    }

    fun checkWinningNumbers(winningNumbers: String) {
        val splitWinningNumbers = winningNumbers.split(",")
        require(splitWinningNumbers.size == 6) { ExceptionMessage.INVALID_COUNT }
        require(splitWinningNumbers.all { it.isNotBlank() && it.isNotEmpty() }) { ExceptionMessage.INPUT_IS_BLANK }
        require(splitWinningNumbers.all { it.isDigit() }) { ExceptionMessage.NOT_NUMBER }
        require(splitWinningNumbers.toSet().size == 6) { ExceptionMessage.DUPLICATED_NUMBER }
        require(splitWinningNumbers.all { it.toInt() in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER }) { ExceptionMessage.INVALID_RANGE_NUMBER }
    }

    fun checkBonusNumber(bonusNumber: String, winningNumber: List<String>) {
        require(bonusNumber.isNotBlank() && bonusNumber.isNotEmpty()) { ExceptionMessage.INPUT_IS_BLANK }
        require(bonusNumber.isDigit()) { ExceptionMessage.NOT_NUMBER }
        require(bonusNumber.toInt() in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER) { ExceptionMessage.INVALID_RANGE_NUMBER }
        require(winningNumber.none { it == bonusNumber }) { ExceptionMessage.DUPLICATED_BONUS_NUMBER }
    }

    fun checkLottoNumbers(lottoNumber: List<Int>) {
        require(lottoNumber.isNotEmpty()) { ExceptionMessage.INVALID_LOTTO_NUMBER + ExceptionMessage.INPUT_IS_BLANK }
        require(lottoNumber.size == LottoConstants.LOTTO_SIZE) { ExceptionMessage.INVALID_LOTTO_NUMBER }
        require(lottoNumber.toSet().size == LottoConstants.LOTTO_SIZE) { ExceptionMessage.INVALID_LOTTO_NUMBER + ExceptionMessage.DUPLICATED_NUMBER }
        require(lottoNumber.all { it in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER }) { ExceptionMessage.INVALID_LOTTO_NUMBER + ExceptionMessage.INVALID_RANGE_NUMBER }
    }

    private fun String.isDigit(): Boolean {
        return all { it.isDigit() }
    }
}