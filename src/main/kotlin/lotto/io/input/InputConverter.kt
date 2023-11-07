package lotto.io.input

import lotto.model.PurchaseInfo
import lotto.model.lotto.Bonus
import lotto.model.lotto.Lotto

class InputConverter {
    fun convertPurchaseInfo(amount: String) =
        PurchaseInfo(amount.toInt())

    fun convertLotto(lottoWithComma: String) =
        Lotto(lottoWithComma.split(",").map { it.toInt() })

    fun convertBonus(bonus: String) =
        Bonus(bonus.toInt())
}