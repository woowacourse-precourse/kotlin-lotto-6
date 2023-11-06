import camp.nextstep.edu.missionutils.Console

object LottoView {
    fun printPurchaseAmountOfLotto() {
        println(PURCHASE_LOTTO_MESSAGE)
    }

    fun inputPurchaseAmountOfLotto(): String {
        val purchaseAmount = Console.readLine()
        return purchaseAmount
    }
}