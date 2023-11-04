package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.Messages

class LottoController {

    private lateinit var lotto: Lotto

    fun startLotto() {
        println(Messages.TEXT_INPUT_LOTTO_AMOUNT.message)
        val amount = Console.readLine()
        val num = inputLottoAmount(amount)
    }

    fun inputLottoAmount(amount: String): Long {
        return amount.toLong() / 1000
    }
}