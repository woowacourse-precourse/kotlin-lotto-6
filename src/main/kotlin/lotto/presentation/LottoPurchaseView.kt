import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoPurchaseView {
    fun printPurchaseAmountOfLotto() {
        println(PURCHASE_LOTTO_MESSAGE)
    }

    fun inputPurchaseAmountOfLotto(): Int {
        val purchaseAmount = Console.readLine()
        LottoController().validateInputPurchaseAmountOfLottoNumeric(purchaseAmount)
        LottoController().validateInputPurchaseAmountOfLottoPositive(purchaseAmount.toInt())
        LottoController().validateInputPurchaseAmountOfLottoDivisionPrice(purchaseAmount.toInt())

        return purchaseAmount.toInt()
    }
}