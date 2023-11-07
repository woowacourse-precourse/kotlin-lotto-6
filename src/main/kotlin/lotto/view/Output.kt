package lotto.view

import lotto.domain.Calculator
import lotto.model.Winning
import lotto.util.Constants.MATCH_FIVE
import lotto.util.Constants.MATCH_FIVE_WITH_BONUS
import lotto.util.Constants.MATCH_FOUR
import lotto.util.Constants.MATCH_SIX
import lotto.util.Constants.MATCH_THREE
import lotto.util.Constants.OUTPUT_NUMBER

class Output {

    fun outputNumber(num: Int) {
        println("$num" + OUTPUT_NUMBER)
    }

    fun outputTickets(ticket: List<Int>) {
        println(ticket.joinToString(", ", "[", "]"))
    }

    fun outputReward(reward: HashMap<Winning, Int>) {
        println(MATCH_THREE + reward.getOrDefault(Winning.FIFTH,0) + "개")
        println(MATCH_FOUR + reward.getOrDefault(Winning.FOURTH,0) + "개")
        println(MATCH_FIVE + reward.getOrDefault(Winning.THIRD,0) + "개")
        println(MATCH_FIVE_WITH_BONUS + reward.getOrDefault(Winning.SECOND,0) + "개")
        println(MATCH_SIX + reward.getOrDefault(Winning.FIRST,0) + "개")
    }

    fun outputYield(amount: Int, rewardResult: HashMap<Winning, Int>) {
        val earnings = Calculator().calculateYield(amount, rewardResult)

        println("총 수익률은 ${earnings}%입니다.")
    }

}