package lotto.domain

import lotto.model.LottoRecord

class Calculator {

    fun calculateYield(amount : Int, reward: HashMap<LottoRecord, Int>) : String{
        return "%.1f".format(addTotalEarnings(reward).toDouble() / amount.toDouble() * 100)
    }

    private fun addTotalEarnings(reward: HashMap<LottoRecord, Int>): Int {

        return reward.getOrDefault(LottoRecord.FIFTH,0) * LottoRecord.FIFTH.reward +
                reward.getOrDefault(LottoRecord.FOURTH,0) * LottoRecord.FOURTH.reward +
                reward.getOrDefault(LottoRecord.THIRD,0) * LottoRecord.THIRD.reward +
                reward.getOrDefault(LottoRecord.SECOND,0) * LottoRecord.SECOND.reward +
                reward.getOrDefault(LottoRecord.FIRST,0) * LottoRecord.FIRST.reward
    }
}