package lotto.io.input

import camp.nextstep.edu.missionutils.Console
import lotto.model.Amount
import lotto.model.Lotto

class Input {
    private val validator = InputValidator()
    private val converter = InputConverter()

    fun inputAmount(): Amount {
        val amount = Console.readLine()
        validator.checkAmount(amount)
        return Amount(amount.toInt())
    }

    fun inputWinningLotto(): Lotto {
        val lottoWithComma = Console.readLine()
        validator.checkWinningLotto(lottoWithComma)
        return converter.convertLotto(lottoWithComma)
    }
}