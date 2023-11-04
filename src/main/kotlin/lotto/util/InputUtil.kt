package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
import lotto.constants.LottoConstants
import lotto.util.OutputUtil.printExceptionMessage

object InputUtil {

    fun inputMoney(): Int =
        checkMoneyAvailable(Console.readLine())

    private fun checkMoneyAvailable(moneyString: String): Int =
        try {
            val money = moneyString.toInt()
            if (money % LottoConstants.LOTTO_PRICE != 0) {
                printExceptionMessage(EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE)
                throw  IllegalArgumentException(EXCEPTION_MESSAGE_MONEY_NOT_DIVIDED_PRICE)
            }
            money
        } catch (e: NumberFormatException) {
            printExceptionMessage(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
            throw IllegalArgumentException(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
        }

}