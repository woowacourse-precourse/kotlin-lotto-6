package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

class InputView {
    private val validator: Validator = Validator()

    fun inputAmount() : Int {
        val input: String? = Console.readLine()
        validator.checkPurchase(input)
        return input!!.toInt()
    }
}