package lotto.view

class OutputView {
    fun printPurchaseAmountInstruction() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseAmountErrorMessage(errorMessage: String) {
        println("[ERROR] $errorMessage")
    }
}