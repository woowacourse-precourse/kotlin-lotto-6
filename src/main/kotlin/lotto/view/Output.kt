package lotto.view

import lotto.domain.Calculator
import lotto.util.Constants.MATCH_FIVE
import lotto.util.Constants.MATCH_FIVE_WITH_BONUS
import lotto.util.Constants.MATCH_FOUR
import lotto.util.Constants.MATCH_SIX
import lotto.util.Constants.MATCH_THREE
import lotto.util.Constants.OUTPUT_NUMBER

class Output {

    fun Blank() {
        println()
    }

    fun outputNumber(num: Int) {
        println("${num}" + OUTPUT_NUMBER)
    }

    fun outputTickets(ticket: List<Int>) {
        println(ticket.joinToString(", ", "[", "]"))
    }

    fun outputReward(rewardResult: List<Int>) {
        println(MATCH_THREE + rewardResult[0] + "개")
        println(MATCH_FOUR + rewardResult[1] + "개")
        println(MATCH_FIVE + rewardResult[2] + "개")
        println(MATCH_FIVE_WITH_BONUS + rewardResult[3] + "개")
        println(MATCH_SIX + rewardResult[4] + "개")
    }

    fun outputYield(amount: Int, rewardResult: List<Int>) {
        val earnings = Calculator().calculateYield(amount, rewardResult)

        println("총 수익률은 ${earnings}%입니다.")
    }

}