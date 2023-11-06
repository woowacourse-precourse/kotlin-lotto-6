import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

object LottoView {
    fun printPurchaseAmountOfLotto() {
        println(PURCHASE_LOTTO_MESSAGE)
    }

    fun inputPurchaseAmountOfLotto(): Int {
        val purchaseAmount = Console.readLine()
        LottoController().validateInputNumeric(purchaseAmount)
        LottoController().validateInputPositive(purchaseAmount.toInt())
        LottoController().validateInputDivisionPrice(purchaseAmount.toInt())

        return purchaseAmount.toInt()
    }

    fun printPurchaseLottoCount(amount: Int) {
        println(PURCHASE_LOTTO_COUNT_MESSAGE.format(amount / LOTTO_PRICE))
    }
}