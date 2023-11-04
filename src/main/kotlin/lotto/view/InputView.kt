package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validateLottoInteger
import lotto.util.Validator.validateLottoNotNull
import lotto.util.Validator.validateLottoSpace

class InputView {
    fun getUserInput(): String = Console.readLine()

    fun getValidInput(): List<Int> {
        val input = getUserInput()
        validateLottoInteger(input)
        validateLottoNotNull(input)
        validateLottoSpace(input)
        return input.map { it.digitToInt() }
    }
}