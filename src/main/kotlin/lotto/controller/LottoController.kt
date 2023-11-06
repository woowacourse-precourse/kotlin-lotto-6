package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoModel
import lotto.view.LottoView
import lotto.utils.ErrorMessage
import lotto.utils.Values

class LottoController(private val view: LottoView, private val model: LottoModel) {
    fun run() {
        view.requestPurchaseMoneyValueMessage()
        checkPurchaseMoneyValue()
    }
    private fun checkPurchaseMoneyValue() {
        while(true) {
            try {
                val moneyValue = Console.readLine().toInt()
                if ((moneyValue % Values.LOTTERY_PRICE) != 0) {
                    throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROATE_VALUE}")
                }
                break
            } catch (e: IllegalArgumentException) {
                println("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROATE_VALUE}")
            }
        }
    }
}