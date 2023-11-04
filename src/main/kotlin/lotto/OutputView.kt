package lotto

class OutputView {
    fun printPurchaseAmountInputMention() = println("구입금액을 입력해 주세요.")

    fun printPurchaseNumber(purchaseNumber: Int) = println("\n${purchaseNumber}개를 구매했습니다.")

    fun printWinningNumberInputMention() = println("\n당첨 번호를 입력해 주세요.")

    fun printBonusNumberInputMention() = println("\n보너스 번호를 입력해 주세요.")

    fun printWinningStatisticsMention() {
        println("\n당첨 통계")
        println("---")
    }

    fun printProfitRate(rate: Double) = println("총 수입률은 ${String.format("%.1f", rate)}%입니다.")

}
