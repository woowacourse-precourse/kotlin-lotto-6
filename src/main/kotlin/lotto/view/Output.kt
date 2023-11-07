package lotto.view

import lotto.domain.Calculator
import lotto.model.LottoRecord
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
        println("$num" + OUTPUT_NUMBER)
    }

    fun outputTickets(ticket: List<Int>) {
        println(ticket.joinToString(", ", "[", "]"))
    }

    fun outputReward(reward: HashMap<LottoRecord, Int>) {
        println(MATCH_THREE + reward.getOrDefault(LottoRecord.FIFTH,0) + "개")
        println(MATCH_FOUR + reward.getOrDefault(LottoRecord.FOURTH,0) + "개")
        println(MATCH_FIVE + reward.getOrDefault(LottoRecord.THIRD,0) + "개")
        println(MATCH_FIVE_WITH_BONUS + reward.getOrDefault(LottoRecord.SECOND,0) + "개")
        println(MATCH_SIX + reward.getOrDefault(LottoRecord.FIRST,0) + "개")
    }

    fun outputYield(amount: Int, rewardResult: HashMap<LottoRecord, Int>) {
        val earnings = Calculator().calculateYield(amount, rewardResult)

        println("총 수익률은 ${earnings}%입니다.")
    }

}