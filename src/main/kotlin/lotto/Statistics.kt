package lotto

import lotto.Constants.FIFTH_PLACE
import lotto.Constants.FIFTH_PRIZE
import lotto.Constants.FIRST_PLACE
import lotto.Constants.FIRST_PRIZE
import lotto.Constants.FOURTH_PLACE
import lotto.Constants.FOURTH_PRIZE
import lotto.Constants.SECOND_PLACE
import lotto.Constants.SECOND_PRIZE
import lotto.Constants.THIRD_PLACE
import lotto.Constants.THIRD_PRIZE

class Statistics(private val amount: Int) {
    enum class Rank(val place: Int, val prize: Int, val str: String) {
        FIFTH(FIFTH_PLACE, FIFTH_PRIZE, "3개 일치"),
        FOURTH(FOURTH_PLACE, FOURTH_PRIZE, "4개 일치"),
        THIRD(THIRD_PLACE, THIRD_PRIZE, "5개 일치"),
        SECOND(SECOND_PLACE, SECOND_PRIZE, "5개 일치, 보너스 볼 일치"),
        FIRST(FIRST_PLACE, FIRST_PRIZE, "6개 일치")
    }

    private val winStat = mutableListOf<Int>(0, 0, 0, 0, 0, 0)

    fun winLotto(purchasedLotto: MutableList<List<Int>>, winNum: List<Int>, bonusNum: Int) {
        purchasedLotto.map { winStat[Lotto(it).isWin(winNum, bonusNum)]++ }
        stat()
    }

    private fun stat() {
        println("\n당첨 통계\n---")
        Rank.values().forEach { rank ->
            println("${rank.str} (${String.format("%,d", rank.prize)}원) - ${winStat[rank.place]}개")
        }
        rateOfReturn()
    }

    private fun rateOfReturn() {
        val total = Rank.values().sumOf { rank ->
            rank.prize * winStat[rank.place]
        }
        val rate = String.format("%.1f", (total / amount.toDouble()) * 100)
        println("총 수익률은 ${rate}%입니다.")
    }
}