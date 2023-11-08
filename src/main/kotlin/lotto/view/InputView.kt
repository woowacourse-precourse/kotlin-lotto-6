package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.ValidateLottoAmount
import lotto.domain.ValidateLottoNumbers
import java.lang.IllegalArgumentException

class InputView {
    fun inputBuyAmount(): Int {
        println(INPUT_BUY_AMOUNT)
        return try {
            ValidateLottoAmount().buyAmount(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBuyAmount()
        }
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBER)
        return try {
            ValidateLottoNumbers().validateWinningNumbers(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputWinningNumbers()
        }

    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        println(INPUT_BONUS_NUMBER)
        return try {
            ValidateLottoNumbers().validateBonusNumber(Console.readLine(), winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber(winningNumbers)
        }
    }

    companion object {
        const val INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    }
}