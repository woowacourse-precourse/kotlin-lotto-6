package lotto.io.input

import lotto.model.PurchaseAmount
import lotto.model.Bonus
import lotto.model.lotto.Lotto

class InputConverter {
    fun convertAmount(amount: String) =
        PurchaseAmount(amount.toInt())

    fun convertLotto(lottoWithComma: String) =
         Lotto(lottoWithComma.split(",").map { it.toInt() })

    fun convertBonus(bonus: String) =
        Bonus(bonus.toInt())
}