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
        inputLottoAmount()
    }

    private fun inputLottoAmount() {
        while (true) {
            try {
                val amount = Console.readLine()
                validateLottoAmount(amount)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateLottoAmount(amount: String) {
        val num = validateOutOfRange(amount)
        validateMoneyUnit(num)
    }
}