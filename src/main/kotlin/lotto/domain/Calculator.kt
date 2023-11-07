package lotto.domain

import lotto.model.LottoRecord

class Calculator {

    fun calculateYield(amount : Int, reward: List<Int>) : String{
        return "%.1f".format(addTotalEarnings(reward).toDouble() / amount.toDouble() * 100)
    }

    private fun addTotalEarnings(reward: List<Int>): Int {

        return reward[0] * LottoRecord.FIFTH.reward +
                reward[1] * LottoRecord.FOURTH.reward +
                reward[2] * LottoRecord.THIRD.reward +
                reward[3] * LottoRecord.SECOND.reward +
                reward[4] * LottoRecord.FIRST.reward
    }
}