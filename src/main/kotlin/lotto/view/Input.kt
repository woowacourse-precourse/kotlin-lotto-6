package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validation.BonusNumberValidation
import lotto.validation.MoneyValidation
import lotto.validation.WinningNumberValidation

class Input {
    fun inputMoney(): Int {
        var money: String
        while(true) {
            println(INPUT_PURCHASE_AMOUNT)
            money = Console.readLine()
            try {
                MoneyValidation.ERROR_VALIDATION.getMessage(money)
                return money.toInt()
            } catch(e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputWinningNumber(): List<Int> {
        println(INPUT_WINNING_NUMBER)
        val winningNumbers = Console.readLine()
        WinningNumberValidation.VALIDATION_START.getMessage(winningNumbers)
        return winningNumbers.split(SPLIT_STRING).map { number ->
            number.toInt()
        }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val number = Console.readLine()
        BonusNumberValidation.ERROR_MESSAGE.getErrorMessage(number)
        return number.toInt()
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
        private const val SPLIT_STRING = ","
    }
}