package lotto

import lotto.LottoSeller.Companion.LOTTO_TICKET_PRICE

class Calculator {
//비교하는 곳 , 나 이거 비교해줘! 라는 곳에 대한 대답
//그러려면 사용자가 입력한 값과 로또 리스트를 비교하는자가 가지고 있어야겠지?

    val lottoResult = mutableMapOf<MatchedCount, Int>(
        MatchedCount.FIFTH to 0,
        MatchedCount.FOURTH to 0,
        MatchedCount.THIRD to 0,
        MatchedCount.SECOND to 0,
        MatchedCount.FIRST to 0,
    )
    private var profitability = 0L
    private var lottoTicketCount = 0
    fun compareNum(
        userLotto: List<Int>,
        bonusNum: Int,
        lottoMachine: List<List<Int>>
    ) {
        //로또속 번호와 사용자가 입력한 번호를 비교해서 몇개가 당첨인지를 알수 있다.
        lottoTicketCount = lottoMachine.size
        for (lotto in lottoMachine) {

            val matchedNumbers = lotto.intersect(userLotto.toSet()).size
            val isBonusMatched = userLotto.contains(bonusNum)    //보너스 볼이 포함 되어 있는지 확인
            val lottoRank = MatchedCount.fromMatchedNumbers(matchedNumbers, isBonusMatched)
            if (lottoRank != MatchedCount.NONE) {
                lottoResult[lottoRank] = lottoResult.getOrDefault(lottoRank, 0) + 1
            }
        }
    }

    fun calculateProfitRate(): Float {
        calculateProfit()
        val moneySpent = lottoTicketCount * LOTTO_TICKET_PRICE
        return (profitability * 100f) / moneySpent
    }

    private fun calculateProfit() {
        lottoResult.forEach { (rank, count) ->
            profitability += rank.prize * count
        }
    }
}
