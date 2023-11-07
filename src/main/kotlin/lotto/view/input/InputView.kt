package lotto.view.input

import lotto.domain.LottoPurchaseAmountParser
import camp.nextstep.edu.missionutils.Console
import lotto.domain.lotto.WinningNumberParser
import lotto.domain.lotto.WinningNumberParser.Companion.parseWinningNumbers

object InputView {
    fun readPurchaseAmount(): Int {
        val input = Console.readLine()
        return try {
            LottoPurchaseAmountParser.parse(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readPurchaseAmount()
        }
    }

    fun readWinningNumber(): List<Int> {
        val input = Console.readLine()
        return try {
            return WinningNumberParser.parseWinningNumbers(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readWinningNumber()
        }
    }
}
