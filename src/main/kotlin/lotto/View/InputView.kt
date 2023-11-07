package lotto.View

import camp.nextstep.edu.missionutils.Console
import lotto.Model.Lotto
import lotto.util.Constants
import lotto.util.Exception

class InputView {
    fun purchaseLottoPrice(): Int {
        while (true) {
            val input = Console.readLine().trim()
            if (isNumeric(input)) {
                runCatching {
                    Exception.checkPurchaseAmountException(input)
                    input.toInt()
                }
                    .onSuccess { return it }
                    .onFailure { println(Constants.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE) }
            } else {
                println(Constants.INPUT_IS_NUMBER_ERROR_MESSAGE)
            }
        }
    }

    fun getWinningNumbers(): Lotto {
        while (true) {
            val input = Console.readLine().trim().split(",")
            if (input.all { isNumeric(it) }) {
                runCatching {
                    Exception.checkWinningNumberException(input)
                    Lotto(input.map { it.toInt() })
                }
                    .onSuccess { return it }
                    .onFailure { println(Constants.WINNING_NUMBER_RANGE_ERROR_MESSAGE) }
            } else {
                println(Constants.INPUT_IS_NUMBER_ERROR_MESSAGE)
            }
        }
    }

    fun getBonusNumber(winningNumber: Lotto): Int {
        while (true) {
            val input = Console.readLine().trim()
            if (isNumeric(input)) {
                runCatching {
                    Exception.checkBonusNumberException(winningNumber, input)
                    input.toInt()
                }
                    .onSuccess { return it }
                    .onFailure { println(Constants.INVALID_BONUS_NUMBER_ERROR_MESSAGE) }
            } else {
                println(Constants.INPUT_IS_NUMBER_ERROR_MESSAGE)
            }
        }
    }

    // 입력값이 숫자인지 확인하는 함수
    private fun isNumeric(input: String): Boolean = input.all { it.isDigit() }
}

