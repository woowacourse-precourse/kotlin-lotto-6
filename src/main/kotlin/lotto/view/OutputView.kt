package lotto.view

import lotto.Constants
import lotto.model.Lottos
import lotto.model.Match
import lotto.model.Reward

class OutputView {
    fun printPurchaseResults(lottos: Lottos) {
        println(
            PURCHASE_COUNT_CONFIRMATION.format(
                lottos.lottoNumbers.size
            )
        )

        println("${lottos}\n")
    }

    fun printWinnigResults(result: MutableMap<Int, Int>) {
        println(
            """
                당첨 통계
                ---
                ${Match.THIRD.info} (${Match.THIRD.amount}원) - ${result[Match.THIRD.count]}개
                ${Match.FOURTH.info} (${Match.FOURTH.amount}원) - ${result[Match.FOURTH.count]}개
                ${Match.FIFTH.info} (${Match.FIFTH.amount}원) - ${result[Match.FIFTH.count]}개
                ${Match.FIFTH_BONUS.info} (${Match.FIFTH_BONUS.amount}원) - ${result[Match.FIFTH_BONUS.count]}개
                ${Match.SIX.info} (${Match.SIX.amount}원) - ${result[Match.SIX.count]}개
            """.trimIndent()
        )
    }

    fun printRateOfReturn(reward: Reward) {
        println("총 수익률은 ${reward.rateOfReturn}%입니다.")
    }

    fun printError(errorMessage: String) = println("${Constants.ERROR_TAG} $errorMessage")

    companion object {
        const val PURCHASE_COUNT_CONFIRMATION = "%d개를 구매했습니다."
    }
}