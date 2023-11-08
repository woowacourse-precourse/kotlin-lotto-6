package lotto

class PrintResult(purchasedLottos: PurchasedLottos) {
    private var calculateIncomeRate = CalculateIncomeRate(purchasedLottos)

    fun printResult() {
        println("3개 일치 (${MATCH_3_INCOME}원) - ${MatchCatalog.Match3.getMatchCount()}개")
        println("4개 일치 (${MATCH_4_INCOME}원) - ${MatchCatalog.Match4.getMatchCount()}개")
        println("5개 일치 (${MATCH_5_INCOME}원) - ${MatchCatalog.Match5.getMatchCount()}개")
        println("5개 일치, 보너스 볼 일치 (${MATCH_Bonus_INCOME}원) - ${MatchCatalog.MatchBonus.getMatchCount()}개")
        println("6개 일치 (${MATCH_6_INCOME}원) - ${MatchCatalog.Match6.getMatchCount()}개")
        println("총 수익률은 ${calculateIncomeRate.calculateTotalIncomeRate()}%입니다.")
    }
}