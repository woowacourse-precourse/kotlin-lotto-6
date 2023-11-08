package lotto.util

import lotto.constants.Error
import lotto.constants.LottoConstants
import lotto.model.Lotto

object LottoValidatorUtil {

    fun checkWinningNumberSize(numbers: List<Int>) {
        when {
            numbers.size != LottoConstants.LOTTO_SIZE -> throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID)
            numbers.toSet().size != LottoConstants.LOTTO_SIZE -> throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
        }
    }

    fun checkNumberInRange(number: Int) {
        if (number !in LottoConstants.LOTTO_RANGE) {
            throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_NOT_IN_RANGE)
        }
    }

    fun checkMoneyAvailable(moneyString: String): Int =
        try {
            val money = moneyString.toInt()
            checkValueDivideByLottoPrice(money)
            money
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
        }

    fun checkWinningNumberAvailable(winningNumberString: String): Lotto =
        try {
            getWinningNumberInWinningNumberString(winningNumberString)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER)
        }


    fun checkNumberOverlap(winningNumber: Lotto, number: Int) {
        if (winningNumber.getNumbers().contains(number)) {
            throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
        }
    }

    private fun getWinningNumberInWinningNumberString(winningNumberString: String): Lotto =
        Lotto(winningNumberString.split(",").map { _numberString ->
            _numberString.toInt()
        })

    private fun checkValueDivideByLottoPrice(money: Int) {
        if (money % LottoConstants.LOTTO_PRICE != 0) {
            throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE)
        }
    }
}

