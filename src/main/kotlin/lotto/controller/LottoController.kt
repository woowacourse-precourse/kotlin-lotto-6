package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.Messages
import lotto.Validation.validateMoneyUnit
import lotto.Validation.validateOutOfRange

class LottoController {

    private lateinit var lotto: Lotto

    fun startLotto() {
        println(Messages.TEXT_INPUT_LOTTO_AMOUNT.message)
        do {
            val amount = Console.readLine()
        } while (inputLottoAmount(amount))
    }

    fun inputLottoAmount(amount: String): Boolean {
        val num = validateOutOfRange(amount)
        validateMoneyUnit(num)
        return true
    }
}