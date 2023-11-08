package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.model.WinningLotto
import lotto.util.Validator

class InputView {
    private val validator: Validator = Validator()

    fun inputAmount() : Int {
        val input: String? = Console.readLine()
        validator.checkPurchase(input)
        return input!!.toInt()
    }

    fun inputWinningNums() : List<Int> {
        val input: String? = Console.readLine()
        validator.checkWinningNums(input)
        return input!!.split(",").map { it.toInt() }
    }

    fun inputBonusNum() : Int {
        val input: String? = Console.readLine()
        validator.checkBonusNum(input)
        return input!!.toInt()
    }
}