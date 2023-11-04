package lotto.view

import lotto.model.Lotto

class OutputView {
    fun printPurchaseAmountInstruction() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseAmountErrorMessage(errorMessage: String) {
        println("[ERROR] $errorMessage")
    }

    fun printNumberOfPurchases(numberOfPurchase: Int) {
        println()
        println("${numberOfPurchase}개를 구매했습니다.")
    }

    fun printLottoNumbers(lotto: Lotto) {
        println(lotto)
    }
}