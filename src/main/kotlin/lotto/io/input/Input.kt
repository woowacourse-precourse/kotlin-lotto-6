package lotto.io.input

import camp.nextstep.edu.missionutils.Console
import lotto.model.PurchaseAmount
import lotto.model.Bonus
import lotto.model.lotto.Lotto

class Input {
    private val validator = InputValidator()
    private val converter = InputConverter()

    fun inputPurchaseAmount(): PurchaseAmount {
        val amount = Console.readLine()
        validator.checkAmount(amount)
        return converter.convertAmount(amount)
    }

    fun inputWinningNumbers(): Lotto {
        val lottoWithComma = Console.readLine()
        validator.checkWinningLotto(lottoWithComma)
        return converter.convertLotto(lottoWithComma)
    }

    fun inputBonusNumber(): Bonus {
        val bonus = Console.readLine()
        validator.checkBonusNumber(bonus)
        return converter.convertBonus(bonus)
    }
}