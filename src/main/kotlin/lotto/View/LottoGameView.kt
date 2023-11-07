object LottoGameView {
    fun printGameResult(winning3: Int, winning4: Int, winning5: Int, winning5Bonus: Int, winning6: Int, lottoListSize: Int) {
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${winning3}개")
        println("4개 일치 (50,000원) - ${winning4}개")
        println("5개 일치 (1,500,000원) - ${winning5}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winning5Bonus}개")
        println("6개 일치 (2,000,000,000원) - ${winning6}개")

        val totalWinningCount = winning3 + winning4 + winning5 + winning5Bonus + winning6
        printProfitRate(totalWinningCount, lottoListSize)
    }

    fun printProfitRate(totalWinningCount: Int, lottoListSize: Int) {
        val profitRate = (totalWinningCount.toDouble() / lottoListSize) * 100
        println("총 수익률은 ${profitRate}%입니다.")
    }
}
