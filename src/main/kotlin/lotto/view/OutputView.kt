package lotto.view

import lotto.domain.LottoBundle
import lotto.domain.LottoRank
import lotto.domain.LottoRank.INIT
import lotto.domain.LottoRank.NOTHING
import java.text.DecimalFormat

object OutputView {
    fun printLottoBundleNumbers(lottoBundle: LottoBundle) {
        println("\n${lottoBundle.amount()}개를 구매했습니다.")
        lottoBundle.forEach { lotto ->
            println(lotto.toString())
        }
        println()
    }

    fun printLottoResult(lottoBundle : LottoBundle){
        printLottoRankResult(lottoBundle)
        printRateOfReturn(lottoBundle)
    }

    fun printLottoRankResult(lottoBundle: LottoBundle) {
        LottoRank.entries.forEach { lottoRank ->
            if (lottoRank != NOTHING && lottoRank != INIT) {
                val rankCount = lottoBundle.winningRanksCount.getValue(lottoRank)
                val lottoPrize = lottoRank.prize.toString()

                println("${lottoRank.message} (${lottoPrize}) - ${rankCount}개")
            }
        }
    }

    fun printRateOfReturn(lottoBundle: LottoBundle) {
        println("총 수익률은 ${DecimalFormat("##0.0").format(lottoBundle.getRateOfReturn())}%입니다.")
    }
}