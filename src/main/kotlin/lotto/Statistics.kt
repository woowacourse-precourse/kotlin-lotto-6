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

class Statistics(private val winStat: List<Int>) {

    fun stat(amount: Int) {
        println("3개 일치 (5,000원) - ${winStat[FIFTH_PLACE]}개")
        println("4개 일치 (50,000원) - ${winStat[FOURTH_PLACE]}개")
        println("5개 일치 (1,500,000원) - ${winStat[THIRD_PLACE]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winStat[SECOND_PLACE]}개")
        println("6개 일치 (2,000,000,000원) - ${winStat[FIRST_PLACE]}개")
        rateOfReturn(amount)
    }

    private fun rateOfReturn(amount: Int) {
        val total =
            FIFTH_PRIZE * winStat[FIFTH_PLACE] + FOURTH_PRIZE * winStat[FOURTH_PLACE]
        +THIRD_PRIZE * winStat[THIRD_PLACE] + SECOND_PRIZE * winStat[SECOND_PLACE]
        +FIRST_PRIZE * winStat[FIRST_PLACE]
        val rate = String.format("%.1f", (total / amount.toDouble()) * 100)
        println("총 수익률은 ${rate}%입니다.")
    }
}