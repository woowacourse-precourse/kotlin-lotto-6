package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Error.EXCEPTION_MESSAGE_MONEY_NOT_NUMBER
import lotto.model.Lotto
import lotto.util.LottoValidatorUtil.checkMoneyAvailable
import lotto.util.LottoValidatorUtil.checkNumberOverlap
import lotto.util.LottoValidatorUtil.checkWinningNumberAvailable

object InputUtil {

    fun inputMoney(): Int =
        checkMoneyAvailable(Console.readLine())

    fun inputWinningNumber(): Lotto =
        checkWinningNumberAvailable(Console.readLine())

    fun inputBonusNumber(winningNumber: Lotto): Int =
        try {
            val number = Console.readLine().toInt()
            LottoValidatorUtil.checkNumberInRange(number)
            checkNumberOverlap(winningNumber, number)
            number
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(EXCEPTION_MESSAGE_MONEY_NOT_NUMBER)
        }
}