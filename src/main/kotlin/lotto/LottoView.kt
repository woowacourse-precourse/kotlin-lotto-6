package lotto

import kotlin.math.round

class LottoView {
    fun showGenerateLotto(lottoCollection: LottoCollection) {
        println("${lottoCollection.collectionSize()}개를 구매했습니다.")
        for (lotto in lottoCollection.lottoCollection) {
            println(lotto.amount())
        }
        println()
    }

    fun showLottoResult(rankNumList: List<Int>) {
        println("당첨 통계\n---")
        for (i in 1..5) {
            when (i) {
                Rank.ONE.rank -> println("6개 일치 (2,000,000,000원) - ${rankNumList[1]}개")
                Rank.TWO.rank -> println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankNumList[2]}개")
                Rank.THREE.rank -> println("5개 일치 (1,500,000원) - ${rankNumList[3]}개")
                Rank.FOUR.rank -> println("4개 일치 (50,000원) - ${rankNumList[4]}개")
                Rank.FIVE.rank -> println("3개 일치 (5,000원) - ${rankNumList[5]}개")
            }
        }
    }

    fun showLottoResultAverage(rankNumList: List<Int>) {
        var sumCost: Double = 0.0
        val count = rankNumList.sum()
        for (i in 0..5) {
            when (i) {
                Rank.ONE.rank -> sumCost += 2000000000 * rankNumList[1]
                Rank.TWO.rank -> sumCost += 30000000 * rankNumList[2]
                Rank.THREE.rank -> sumCost += 1500000 * rankNumList[3]
                Rank.FOUR.rank -> sumCost += 50000 * rankNumList[4]
                Rank.FIVE.rank -> sumCost += 5000 * rankNumList[5]
            }
        }
        val averagePercent = round((sumCost / (count * 10)) * 10) / 10
        println("총 수익률은 ${averagePercent}%입니다.")
    }
}