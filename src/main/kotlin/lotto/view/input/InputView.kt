package lotto.view.input

import lotto.domain.purchase.LottoPurchaseAmountParser
import camp.nextstep.edu.missionutils.Console
import lotto.constants.ErrorConstants
import lotto.domain.lotto.parser.LottoNumberParser
import lotto.domain.winningnumber.parser.WinningNumberParser

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
            val parseWinningNumbers = WinningNumberParser.parseWinningNumbers(input)
            parseWinningNumbers
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readWinningNumber()
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        val input = Console.readLine()
        return try {
            val bonusNumber = LottoNumberParser.parseNumber(input)
            validateBonusNumberNotInWinningNumbers(bonusNumber = bonusNumber, winningNumbers = winningNumbers)
            bonusNumber
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBonusNumber(winningNumbers)
        }
    }

    private fun validateBonusNumberNotInWinningNumbers(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException(ErrorConstants.DISTINCT_BONUS_NUMBER_ERROR_MESSAGE)
        }
    }
}
