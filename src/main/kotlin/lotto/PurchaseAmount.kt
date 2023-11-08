package lotto

import lotto.Converter.convertStringToInt
import lotto.ErrorConstants.INVALID_MONEY_UNIT_ERROR
import lotto.ErrorConstants.NEGATIVE_INPUT_ERROR
import lotto.ErrorConstants.NUMBER_FORMAT_ERROR
import lotto.LottoConstants.LOTTO_PRICE
import lotto.LottoConstants.MINIMUM_PRICE

object PurchaseAmount {

    fun processPurchaseAmount(userInput: String): Int = runCatching {
        convertStringToInt(userInput).apply {
            validatePurchasePrice(this)
        }
    }.getOrElse { throwable ->
        when (throwable) {
            is NumberFormatException -> throw IllegalArgumentException(NUMBER_FORMAT_ERROR)
            else -> throw IllegalArgumentException(throwable.message)
        }
    }

    private fun validatePurchasePrice(price: Int) {
        require(price > MINIMUM_PRICE) { NEGATIVE_INPUT_ERROR }
        require(price % LOTTO_PRICE == MINIMUM_PRICE) { INVALID_MONEY_UNIT_ERROR }
    }
}
