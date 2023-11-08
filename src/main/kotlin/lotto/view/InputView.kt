package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.validation.InputValidator

class InputView {
    private val inputValidator = InputValidator()
    fun inputMoney(): Int {
        while(true) {
            println(INPUT_PURCHASE_AMOUNT)
            try {
                return inputValidator.validateMoney(Console.readLine())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputWinningNumber(): Lotto {
        while (true) {
            println(INPUT_WINNING_NUMBER)
            try {
                val result = inputValidator.validateWinningNumber(Console.readLine())
                return Lotto(result)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            println(INPUT_BONUS_NUMBER)
            try {
                return inputValidator.validateBonusNumber(Console.readLine())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    }
}