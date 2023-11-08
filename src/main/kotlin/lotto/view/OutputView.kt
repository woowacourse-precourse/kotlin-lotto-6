package lotto.view

import lotto.domain.Lotto

class OutputView {

    fun printReceivePurchaseAmountInput() = println("구입금액을 입력해 주세요.")

    fun printLottoGenerateCount(generateCount: Int) {
        println()
        println("${generateCount}개를 구매했습니다.")
    }

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { println(it.returnLottoNumbers()) }
    }

    fun printReceiveWinningNumbersInput() {
        println()
        println("당첨 번호를 입력해 주세요.")
    }

    fun printReceiveBonusNumberInput() {
        println()
        println("보너스 번호를 입력해 주세요.")
    }

    fun printWinningStatistics() {
        println()
        println("당첨 통계")
        println("---")
    }

    fun printWinningStatisticsResult(rankDescription: String, prizeMoney: String, count: Int) {
        println("$rankDescription (${prizeMoney}원) - ${count}개")
    }

    fun printProfitRateResult(profitRate: String) {
        println("총 수익률은 ${profitRate}%입니다.")
    }
}