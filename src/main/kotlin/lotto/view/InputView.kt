package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validateLottoInteger

class InputView {
    fun getUserInput(): String = Console.readLine()

    fun getValidLottoInput(): List<Int> {
        val input = getUserInput()
        validateLottoInteger(input)
        return input.split(",").map { it.toInt() }
    }
}