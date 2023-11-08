package lotto.model

import lotto.COST_UNIT
import lotto.exception.NotPositiveCostException
import lotto.exception.UnvalidCostException

class Cost(private val cost: Int) {
    private var lottoCount : Int = cost / COST_UNIT

    fun getCost(): Int {
        return cost
    }

    fun getLottoCount(): Int {
        return lottoCount
    }
}