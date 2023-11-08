package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants

object InputView {
    fun inputPurchasedMoney(): Int {
        println(Constants.PURCHASED_MONEY_INPUT_MESSAGE)
        return Console.readLine().stringToInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println(Constants.WINNING_NUMBER_INPUT_MESSAGE)
        return Console.readLine().trim().split(",").map { it.stringToInt() }
    }

    fun inputBonusNumber(): Int {
        println(Constants.BONUS_NUMBER_INPUT_MESSAGE)
        return Console.readLine().stringToInt()
    }

    private fun String.stringToInt(): Int =
        this.toIntOrNull() ?: throw IllegalArgumentException(Constants.LOTTO_NUMBER_TYPE_ERROR_MESSAGE)
}