package lotto.view

import lotto.domain.Calculator
import lotto.model.Winning
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
                Winning.SECOND -> showResultWithBonus(
                    it.match,
                    formatMoney(it.reward),
                    reward.getOrDefault(it, 0)
                )

                else -> showResult(it.match, formatMoney(it.reward), reward.getOrDefault(it, 0))
            }
        }
    }

    private fun showResult(match: Int, winning: String, count: Int) {
        println("${match}개 일치 (${winning}원) - ${count}개")
    }

    private fun showResultWithBonus(match: Int, winning: String, count: Int) {
        println("${match}개 일치, 보너스 볼 일치 (${winning}원) - ${count}개")
    }

    fun outputYield(amount: Int, rewardResult: HashMap<Winning, Int>) {
        val earnings = Calculator().calculateYield(amount, rewardResult)

        println("총 수익률은 ${earnings}%입니다.")
    }

    private fun formatMoney(money: Int): String {
        return "%,d".format(money)
    }

}