package lotto.util

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Check.checkBonusNumber
import lotto.util.Check.checkMoney
import lotto.util.Check.checkWinningNumbers
import lotto.view.Message
import kotlin.math.roundToInt

object Util {

    fun requestMoney(): Int {

        val purchasePrice = Console.readLine().toIntOrNull()

        checkMoney(purchasePrice)

        return purchasePrice!!

    }

    fun requestWinningNumbers(): MutableList<Int?> {
        println(Message.REQUEST_WINNING_NUMBERS.message)

        val input = Console.readLine()

        val winningNumbersList = input
            .replace(" ", "")
            .split(",")
            .map { it.toIntOrNull() }
            .toMutableList()

        checkWinningNumbers(winningNumbersList)

        return winningNumbersList
    }

    fun requestBonusNumber(): Int {
        println(Message.REQUEST_BONUS_NUMBER.message)

        val bonusNumber = Console.readLine().toIntOrNull()

        checkBonusNumber(bonusNumber)

        return bonusNumber!!
    }

    fun getLottoTicket(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)


    fun getRoi(investment: Int, prizeMoney: Int): Double {
        val roi = (prizeMoney.toDouble() / investment) * 100

        return (roi * 10.0).roundToInt() / 10.0

    }

}