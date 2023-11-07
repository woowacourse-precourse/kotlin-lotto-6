package lotto.view.input

import lotto.domain.purchase.LottoPurchaseAmountParser
import camp.nextstep.edu.missionutils.Console
import lotto.constants.ErrorConstants.DISTINCT_BONUS_NUMBER_ERROR_MESSAGE
import lotto.controller.LottoGameController
import lotto.domain.lotto.parser.LottoNumberParser
import lotto.domain.winningnumber.WinningNumberParser
import lotto.view.output.OutputView

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
        println("당첨 번호를 입력해 주세요. (예: 1, 2, 3, 4, 5, 6)")
        val input = Console.readLine()
        return try {
            WinningNumberParser.parseWinningNumbers(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readWinningNumber()
        }
    }

    fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
        return try {
            LottoNumberParser.parseNumber(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBonusNumber()
        }
    }

    fun validateBonusNumberNotInWinningNumbers(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException(DISTINCT_BONUS_NUMBER_ERROR_MESSAGE)
        }
    }
}
