package lotto

class OutputView {

    fun printRequestInputPurchaseAmount() {
        println(REQUEST_INPUT_PURCHASE_AMOUNT)
    }

    fun printLottoQuantity(quantity: Int) {
        println("\n$quantity$NUMBER_OF_PURCHASES")
    }

    companion object {
        const val REQUEST_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val NUMBER_OF_PURCHASES = "개를 구매했습니다."
    }

}