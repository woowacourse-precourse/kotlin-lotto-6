import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoPurchaseView {
    fun printMoneyToBuy() {
        println(PURCHASE_LOTTO_MESSAGE)
    }

    fun inputMoneyToBuy(): Int {
        val purchaseAmount = Console.readLine()
        LottoController().validateMoneyToBuyNumeric(purchaseAmount)
        LottoController().validateMoneyToBuyPositive(purchaseAmount.toInt())
        LottoController().validateMoneyToBuyDivisibleByLottoPrice(purchaseAmount.toInt())

        return purchaseAmount.toInt()
    }
}