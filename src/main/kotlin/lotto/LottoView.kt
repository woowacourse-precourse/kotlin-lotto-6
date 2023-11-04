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
                1 -> println("6개 일치 (2,000,000,000원) - ${rankNumList[1]}개")
                2 -> println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankNumList[2]}개")
                3 -> println("5개 일치 (1,500,000원) - ${rankNumList[3]}개")
                4 -> println("4개 일치 (50,000원) - ${rankNumList[4]}개")
                5 -> println("3개 일치 (5,000원) - ${rankNumList[5]}개")
            }
        }
    }

    fun showLottoResultAverage(rankNumList: List<Int>) {
        var sumCost: Double = 0.0
        val count = rankNumList.sum()
        for (i in 0..5) {
            when (i) {
                1 -> sumCost += 2000000000 * rankNumList[1]
                2 -> sumCost += 30000000 * rankNumList[2]
                3 -> sumCost += 1500000 * rankNumList[3]
                4 -> sumCost += 50000 * rankNumList[4]
                5 -> sumCost += 5000 * rankNumList[5]
            }
        }
        val averagePercent = round((sumCost / (count * 10)) * 100 / 100)
        println("총 수익률은 ${averagePercent}%입니다.")
    }
}