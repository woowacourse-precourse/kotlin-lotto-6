package lotto.exception.model

import lotto.COST_UNIT
import lotto.exception.NotPositiveCostException
import lotto.exception.UnvalidCostException

class Cost(private val cost: Int) {
    fun checkValidateCost(): Boolean {
        if (!checkPositiveNumber())
            throw NotPositiveCostException()
        if (!checkDivideByCostUnit())
            throw UnvalidCostException()
        return true
    }

    private fun checkDivideByCostUnit(): Boolean {
        return cost / COST_UNIT == 0
    }

    private fun checkPositiveNumber(): Boolean {
        return cost > 0
    }

    fun getCost(): Int {
        return cost
    }
}