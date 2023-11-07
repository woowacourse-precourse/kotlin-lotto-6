package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constant
import lotto.util.Exception

class InputView {

    fun inputPrice(): Int {
        val price = Console.readLine()
        Exception.validateInputPrice(price)
        return price.toInt()
    }

    fun inputLuckyNumber(): List<Int> {
        val luckyNumbers = Console.readLine().split(",")
        for (luckyNumber in luckyNumbers) {
            requireNotNull(luckyNumber.toIntOrNull()) { Constant.INPUT_WINNING_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        }
        return luckyNumbers.map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        requireNotNull(bonusNumber.toIntOrNull()) { Constant.INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        return bonusNumber.toInt()
    }
}