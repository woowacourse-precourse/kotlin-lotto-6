package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST
import lotto.constants.Error.EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER
import lotto.constants.LottoConstants
import lotto.constants.LottoConstants.LOTTO_SIZE
import lotto.util.OutputUtil.printExceptionMessage

object InputUtil {

    fun inputMoney(): Int =
        checkMoneyAvailable(Console.readLine())

    fun inputWinningNumber(): List<Int> =
        checkWinningNumberAvailable(Console.readLine())


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

    private fun checkWinningNumberAvailable(winningNumberString: String): List<Int> =
        try {
            val winningNumber = winningNumberString.split(",").map { _numberString ->
                _numberString.toInt()
            }
            checkWinningNumberSize(winningNumber)
            winningNumber
        } catch (e: NumberFormatException) {
            printExceptionMessage(EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_WINNING_NUMBER_NOT_NUMBER)
        }

    private fun checkWinningNumberSize(winningNumber: List<Int>) {
        if (winningNumber.toSet().size < LOTTO_SIZE) {
            printExceptionMessage(EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
        }
    }
}