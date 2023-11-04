package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
import lotto.constants.Error.EXCEPTION_MESSAGE_NOT_IN_RANGE
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID
import lotto.constants.LottoConstants
import lotto.constants.LottoConstants.LOTTO_RANGE
import lotto.constants.LottoConstants.LOTTO_SIZE
import lotto.model.Lotto
import lotto.util.OutputUtil.printExceptionMessage

object InputUtil {

    fun inputMoney(): Int =
        checkMoneyAvailable(Console.readLine())

    fun inputWinningNumber(): Lotto =
        checkWinningNumberAvailable(Console.readLine())

    fun inputBonusNumber(winningNumber: Lotto): Int =
        try {
            val number = Console.readLine().toInt()
            checkNumberInRange(number)
            checkNumberOverlap(winningNumber, number)
            number
        } catch (e: NumberFormatException) {
            printExceptionMessage(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
        }

    private fun checkMoneyAvailable(moneyString: String): Int =
        try {
            val money = moneyString.toInt()
            if (money % LottoConstants.LOTTO_PRICE != 0) {
                printExceptionMessage(EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE)
                throw IllegalArgumentException(EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE)
            }
            money
        } catch (e: NumberFormatException) {
            printExceptionMessage(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
        }

    private fun checkWinningNumberAvailable(winningNumberString: String): Lotto =
        try {
            val winningNumber = Lotto(winningNumberString.split(",").map { _numberString ->
                val number = _numberString.toInt()
                checkNumberInRange(number)
                number
            })
            checkWinningNumberSize(winningNumber)
            winningNumber
        } catch (e: NumberFormatException) {
            printExceptionMessage(EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER)
        }

    private fun checkWinningNumberSize(winningNumber: Lotto) {
        when {
            winningNumber.getNumbers().size != LOTTO_SIZE -> {
                printExceptionMessage(EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID)
                throw IllegalArgumentException(EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID)
            }
            winningNumber.getNumbers().toSet().size != LOTTO_SIZE -> {
                printExceptionMessage(EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
                throw IllegalArgumentException(EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
            }
        }
    }

    private fun checkNumberInRange(number: Int) {
        if (number !in LOTTO_RANGE) {
            printExceptionMessage(EXCEPTION_MESSAGE_NOT_IN_RANGE)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_NOT_IN_RANGE)
        }
    }

    private fun checkNumberOverlap(winningNumber: Lotto, number: Int) {
        if (winningNumber.getNumbers().contains(number)) {
            printExceptionMessage(EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
        }
    }
}