package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.GameConstants.SEPARATOR
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateNatural
import lotto.util.Validator.validateNull

class InputView {
    private fun getUserInput(): String = Console.readLine()

    fun getInteger(): Int {
        val input = getUserInput()
        validateNull(input)
        validateInteger(input)
        validateNatural(input)
        return input.toInt()
    }

    fun getLotto(): List<Int> {
        val input = getUserInput()
        validateNull(input)
        return input.split(SEPARATOR).map { it.toInt() }
    }
}