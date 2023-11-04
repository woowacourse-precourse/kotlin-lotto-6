package lotto.utils

import lotto.model.Lotto
import lotto.utils.Constant.AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE
import lotto.utils.Constant.WINNING_NUMBER_RANGE_ERROR_MESSAGE
import lotto.utils.Constant.INVALID_WINNING_NUMBER_ERROR_MESSAGE
import lotto.utils.Constant.LOTTO_COST
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER


object Exceptions {

    fun inputPurchaseAmountException(purchaseAmount: String): Result<Int> {
        return runCatching {
            val intValue = purchaseAmount.toInt()
            require(intValue % LOTTO_COST == 0) { AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE }
            intValue
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }

    fun inputWinningNumberException(winningNumber: List<String>): Result<Lotto> {
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

}