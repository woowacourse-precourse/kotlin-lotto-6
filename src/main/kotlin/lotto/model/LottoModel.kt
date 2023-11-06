package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.ErrorMessage
import lotto.utils.Values
import kotlin.properties.Delegates

class LottoModel {
    var lotteryAmount by Delegates.notNull<Int>()
    fun isPurchaseMoneyValueValid(moneyValue: String): Boolean {
        return try {
            if ((moneyValue.toInt() % Values.LOTTERY_PRICE) != 0) {
                throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROPRIATE_VALUE}")
            }
            lotteryAmount = moneyValue.toInt() / Values.LOTTERY_PRICE
            false
        } catch (e: IllegalArgumentException) {
            true
        }
    }
}