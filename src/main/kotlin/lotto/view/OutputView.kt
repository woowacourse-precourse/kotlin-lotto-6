package lotto.view

import lotto.model.Lotto
import util.Constants.FIFTH_RANK
import util.Constants.FIRST_RANK
import util.Constants.FOURTH_RANK
import util.Constants.SECOND_RANK
import util.Constants.THIRD_RANK

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
        println("3개 일치 (5,000원) - ${winningRanks[FIFTH_RANK]}개")
        println("4개 일치 (50,000원) - ${winningRanks[FOURTH_RANK]}개")
        println("5개 일치 (1,500,000원) - ${winningRanks[THIRD_RANK]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningRanks[SECOND_RANK]}개")
        println("6개 일치 (2,000,000,000원) - ${winningRanks[FIRST_RANK]}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        val formattedRateOfReturn = String.format("%.1f", rateOfReturn)
        println("총 수익률은 ${formattedRateOfReturn}%입니다.")
    }
}