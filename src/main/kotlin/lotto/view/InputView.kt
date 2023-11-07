package lotto.view

import lotto.constants.Constants
import camp.nextstep.edu.missionutils.Console
import lotto.domain.ValidateLottoAmount
import lotto.domain.ValidateLottoNumbers
import java.lang.IllegalArgumentException

class InputView {
    fun inputBuyAmount(): Int {
        println(Constants.INPUT_BUY_AMOUNT)
        return try {
           ValidateLottoAmount().buyAmount(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBuyAmount()
        }
    }

    fun inputWinningNumbers() : List<Int> {
        println(Constants.INPUT_WINNING_NUMBER)
        return try {
            ValidateLottoNumbers().validateWinningNumbers(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputWinningNumbers()
        }

    }

    fun inputBonusNumber(winningNumbers: List<Int>) : Int {
        println(Constants.INPUT_BONUS_NUMBER)
        return try {
            ValidateLottoNumbers().validateBonusNumber(Console.readLine(), winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber(winningNumbers)
        }
    }
}