package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.util.FormatUtil

object OutputView {

    fun printPurchaseLottoCount(purchaseLottoCount: Int) {
        println("\n${purchaseLottoCount}개를 구매했습니다.")
    }

    fun printPurchaseLottos(purchaseLottos: List<Lotto>) {
        purchaseLottos.forEach { println(it.getNumbers()) }
    }

    fun printResult(result: Map<Rank, Int>) {
        println("\n당첨 통계\n---")
        Rank.entries.forEach { rank ->
            val count = result[rank] ?: 0
            when (rank) {
                Rank.SECOND -> println("${rank.matchCount}개 일치, 보너스 볼 일치 (${FormatUtil.formatReward(rank.reward)}원) - ${count}개")
                else -> println("${rank.matchCount}개 일치 (${FormatUtil.formatReward(rank.reward)}원) - ${count}개")
            }
        }
    }

    fun printEarningRate(earningRate: String) {
        println("총 수익률은 $earningRate%입니다.")
    }
}