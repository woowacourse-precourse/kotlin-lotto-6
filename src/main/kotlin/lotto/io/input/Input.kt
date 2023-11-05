package lotto.io.input

import camp.nextstep.edu.missionutils.Console
import lotto.model.PurchaseInfo
import lotto.model.lotto.Bonus
import lotto.model.lotto.Lotto

class Input {
    private val validator = InputValidator()
    private val converter = InputConverter()

    fun inputPurchaseAmount(): PurchaseInfo {
        val amount = Console.readLine()
        validator.checkInputDigit(amount)
        return converter.convertPurchaseInfo(amount)
    }

    fun inputWinningNumbers(): Lotto {
        val lottoWithComma = Console.readLine()
        validator.checkWinningLotto(lottoWithComma)
        return converter.convertLotto(lottoWithComma)
    }

    fun inputBonusNumber(): Bonus {
        val bonus = Console.readLine()
        validator.checkInputDigit(bonus)
        return converter.convertBonus(bonus)
    }
}