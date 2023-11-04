package view

class OutputView {

    fun printPurchaseAmount() = println(RequestType.PURCHASE_AMOUNT.message)

    private enum class RequestType(val message: String) {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    }
}
