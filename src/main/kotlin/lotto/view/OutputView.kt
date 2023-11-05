package lotto.view

object OutputView {

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println("[${lottoNumbers.sorted().joinToString(", ")}]")
    }

    fun printLottoCount(purchaseCount: Int) {
        println("$purchaseCount$RESULT_AMOUNT_PURCHASE_MESSAGE")
    }

    const val RESULT_AMOUNT_PURCHASE_MESSAGE = "개를 구매했습니다."
}