package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.validation.BonusNumberValidation
import lotto.validation.MoneyValidation
import lotto.validation.WinningNumberValidation

class InputView {
    fun inputMoney(): Int {
        while(true) {
            println(INPUT_PURCHASE_AMOUNT)
            val money: String = Console.readLine()
            try {
                MoneyValidation.ERROR_VALIDATION.getMessage(money)
                return money.toInt()
            } catch(e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputWinningNumber(): Lotto {
        while (true) {
            println(INPUT_WINNING_NUMBER)
            val winningNumbers = Console.readLine()
            try {
                WinningNumberValidation.VALIDATION_START.getMessage(winningNumbers)
                val result = winningNumbers.split(SPLIT_STRING).map { number ->
                    number.toInt()
                }
                return Lotto(result)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            println(INPUT_BONUS_NUMBER)
            val number = Console.readLine()
            try {
                BonusNumberValidation.ERROR_MESSAGE.getErrorMessage(number)
                return number.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
        private const val SPLIT_STRING = ","
    }
}