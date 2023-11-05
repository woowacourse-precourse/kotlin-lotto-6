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

    fun printLotto(lotto: Lotto) {
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

    fun printWinningStatisticsInstruction() {
        println()
        println("당첨 통계")
        println("---")
    }

    fun printWinningStatistics(winningRanks: List<Int>) {
        println("3개 일치 (5,000원) - ${winningRanks[5]}개")
        println("4개 일치 (50,000원) - ${winningRanks[4]}개")
        println("5개 일치 (1,500,000원) - ${winningRanks[3]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningRanks[2]}개")
        println("6개 일치 (2,000,000,000원) - ${winningRanks[1]}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        val formattedRateOfReturn = String.format("%.1f", rateOfReturn)
        println("총 수익률은 ${formattedRateOfReturn}%입니다.")
    }
}