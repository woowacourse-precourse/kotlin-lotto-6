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
        Winning.entries.filter { it != Winning.NONE }.forEach {
            when (it) {
                Winning.SECOND ->
                    println(
                        "${it.match}개 일치, 보너스 볼 일치 (${formatMoney(it.reward)}원) - ${
                            reward.getOrDefault(
                                it,
                                0
                            )
                        }개"
                    )

                else -> println(
                    "${it.match}개 일치 (${formatMoney(it.reward)}원) - ${
                        reward.getOrDefault(
                            it,
                            0
                        )
                    }개"
                )
            }
        }
    }

    fun outputYield(amount: Int, rewardResult: HashMap<Winning, Int>) {
        val earnings = Calculator().calculateYield(amount, rewardResult)

        println("총 수익률은 ${earnings}%입니다.")
    }

    private fun formatMoney(money: Int): String {
        return "%,d".format(money)
    }

}