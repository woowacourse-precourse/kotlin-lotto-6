package lotto.domain

import java.lang.IllegalArgumentException

class ValidateLottoAmount {
    fun buyAmount(buyAmount: String): Int =
        validateBuyAmount(buyAmount)

    private fun validateBuyAmount(buyAmount: String): Int =
        validateBuyAmountEmpty(buyAmount)

    fun validateBuyAmountEmpty(buyAmount: String): Int {
        if (buyAmount.isEmpty()) throw IllegalArgumentException(BUY_AMOUNT_EMPTY_ERROR_MESSAGE)
        return validateBuyAmountString(buyAmount)
    }

    fun validateBuyAmountString(buyAmount: String): Int {
        for (char in buyAmount.toCharArray()) {
            if (!char.isDigit()) throw IllegalArgumentException(BUY_AMOUNT_STRING_ERROR_MESSAGE)
        }
        return validateBuyAmountUnderLottoPrice(buyAmount.toInt())
    }

    fun validateBuyAmountUnderLottoPrice(buyAmount: Int): Int {
        if (buyAmount < LOTTO_PRICE) throw IllegalArgumentException(BUY_AMOUNT_UNDER_LOTTO_PRICE_ERROR_MESSAGE)
        return validateBuyAmountDivideByLottoPrice(buyAmount)
    }

    fun validateBuyAmountDivideByLottoPrice(buyAmount: Int): Int {
        if (buyAmount % LOTTO_PRICE != 0)
            throw IllegalArgumentException(BUY_AMOUNT_DIVIDE_BY_LOTTO_PRICE_ERROR_MESSAGE)
        return buyAmount / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val BUY_AMOUNT_EMPTY_ERROR_MESSAGE = "[ERROR] 입력하지 않았습니다."
        const val BUY_AMOUNT_STRING_ERROR_MESSAGE = "[ERROR] 입력한 값에 문자가 포함되어 있습니다."
        const val BUY_AMOUNT_UNDER_LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 입력한 값으로 로또 구매가 불가능합니다."
        const val BUY_AMOUNT_DIVIDE_BY_LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 입력한 값은 1,000원으로 나누어 떨어지지 않습니다."
    }
}