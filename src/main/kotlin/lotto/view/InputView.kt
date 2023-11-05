package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateLottoInteger
import lotto.util.Validator.validateNotNull

class InputView {
    fun getUserInput(): String = Console.readLine()

    fun getValidLottoInput(): List<Int> {
        val input = getUserInput()
        validateNotNull(input)
        validateLottoInteger(input)
        return input.split(",").map { it.toInt() }
    }

    fun getValidIntegerInput(): Int {
        val input = getUserInput()
        validateNotNull(input)
        validateInteger(input)
        return input.toInt()
    }
}