package lotto

import lotto.ErrorConstants.DUPLICATE_NUMBER_ERROR
import lotto.ErrorConstants.INVALID_LOTTO_NUMBER_ERROR
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN

class BonusNumber {
    companion object {
        fun processBonusNumber(userInput: String, winningTicket: Lotto): Int = runCatching {
            Converter.convertStringToInt(userInput).apply {
                validateBonusNumber(this, winningTicket)
            }
        }.getOrElse { throwable ->
            when (throwable) {
                is NumberFormatException -> throw IllegalArgumentException(ErrorConstants.NUMBER_FORMAT_ERROR)
                else -> throw IllegalArgumentException(throwable.message)
            }
        }

        private fun validateBonusNumber(number: Int, winningTicket: Lotto) {
            require(!winningTicket.contains(number)) { DUPLICATE_NUMBER_ERROR }
            require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { INVALID_LOTTO_NUMBER_ERROR }
        }

    }
}
