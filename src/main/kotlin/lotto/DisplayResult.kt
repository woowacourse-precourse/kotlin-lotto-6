package lotto


fun displayPurchasement(lottoGameTicketCount:Int, tickets: List<Lotto>){
    println("${lottoGameTicketCount}개를 구매했습니다.")
    tickets.forEach { displayTicketInfo(it) }
}

fun displayTicketInfo(ticket:Lotto){
    println(ticket)
}

fun displayResult(rewardRate: Double, rankCounts: Map<LottoRank, Int>) {
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${rankCounts.getValue(LottoRank.FIFTH)}개")
    println("4개 일치 (50,000원) - ${rankCounts.getValue(LottoRank.FOURTH)}개")
    println("5개 일치 (1,500,000원) - ${rankCounts.getValue(LottoRank.THIRD)}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankCounts.getValue(LottoRank.SECOND)}개")
    println("6개 일치 (2,000,000,000원) - ${rankCounts.getValue(LottoRank.FIRST)}개")
    println("총 수익률은 ${"%.1f".format(rewardRate)}%입니다.")
}