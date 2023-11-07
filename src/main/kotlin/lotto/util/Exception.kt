package lotto.util

import lotto.Model.Lotto
import lotto.util.Constants.Companion.AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE
import lotto.util.Constants.Companion.DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE
import lotto.util.Constants.Companion.INVALID_BONUS_NUMBER_ERROR_MESSAGE
import lotto.util.Constants.Companion.INVALID_WINNING_NUMBER_ERROR_MESSAGE
import lotto.util.Constants.Companion.LOTTO_PRICE
import lotto.util.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.util.Constants.Companion.MIN_LOTTO_NUMBER
import lotto.util.Constants.Companion.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE
import lotto.util.Constants.Companion.WINNING_NUMBER_RANGE_ERROR_MESSAGE

object Exception {
    fun checkPurchaseAmountException(purchaseAmount: String): Result<Int> {
        return runCatching {
            val intValue = purchaseAmount.toInt()
            require(intValue % LOTTO_PRICE == 0) { AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE }
            intValue
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }

    fun checkWinningNumberException(winningNumber: List<String>): Result<Lotto> {
        return runCatching {
            Lotto(winningNumber.map {
                val intValue = it.toInt()
                require(intValue in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { WINNING_NUMBER_RANGE_ERROR_MESSAGE }
                intValue
            })
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(INVALID_WINNING_NUMBER_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }

    fun checkBonusNumberException(winningNumber: Lotto, bonusNumber: String): Result<Int> {
        return runCatching {
            val intValue = bonusNumber.toInt()
            require(intValue !in winningNumber.getNumbers()) { DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE }
            require(intValue in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { WINNING_NUMBER_RANGE_ERROR_MESSAGE }
            intValue
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(INVALID_BONUS_NUMBER_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }
}
