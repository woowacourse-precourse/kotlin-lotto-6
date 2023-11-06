package lotto

import lotto.Constants.FIFTH_PLACE
import lotto.Constants.FIRST_PLACE
import lotto.Constants.FOURTH_PLACE
import lotto.Constants.SECOND_PLACE
import lotto.Constants.THIRD_PLACE

class Statistics(private val winStat: List<Int>) {

    fun stat() {
        println("\n당첨 통계\n---\n")
        println("3개 일치 (5,000원) - ${winStat[FIFTH_PLACE]}개")
        println("4개 일치 (50,000원) - ${winStat[FOURTH_PLACE]}개")
        println("5개 일치 (1,500,000원) - ${winStat[THIRD_PLACE]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winStat[SECOND_PLACE]}개")
        println("6개 일치 (2,000,000,000원) - ${winStat[FIRST_PLACE]}개")
    }
}