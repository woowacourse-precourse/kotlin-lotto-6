package lotto.view.input

import lotto.domain.purchase.LottoPurchaseAmountParser
import camp.nextstep.edu.missionutils.Console
import lotto.domain.lotto.parser.LottoNumberParser
import lotto.domain.lotto.wrapper.LottoNumber
import lotto.domain.winningNumber.WinningNumberParser

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
            WinningNumberParser.parseWinningNumbers(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readWinningNumber()
        }
    }

    fun readBonusNumber(): Int {
        val input = Console.readLine()
        return try {
            LottoNumberParser.parseNumber(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBonusNumber()
        }
    }
}
