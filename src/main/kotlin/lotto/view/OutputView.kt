package lotto.view

import lotto.model.Lotto

class OutputView {
    fun printPurchaseAmountInstruction() {
        println("구입금액을 입력해 주세요.")
    }

    fun printErrorMessage(errorMessage: String) {
        println("[ERROR] $errorMessage")
    }

    fun printNumberOfPurchases(numberOfPurchase: Int) {
        println()
        println("${numberOfPurchase}개를 구매했습니다.")
    }

    fun printLottoNumbers(lotto: Lotto) {
        println(lotto)
    }

    fun printWinningNumbersInstruction() {
        println()
        println("당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumberInstruction() {
        println()
        println("보너스 번호를 입력해 주세요.")
    }
}