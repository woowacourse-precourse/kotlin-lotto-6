package lotto.utils.validator

import lotto.LottoOutputHandler

object LottoCostInputValidator{
    fun validate(cost: String) : LottoInputState.Cost {
        val costState = getState(cost.toIntOrNull())
        if (costState != LottoInputState.Cost.SUCCESSFUL){
            LottoOutputHandler.displayLottoCostErrorMessage(costState)
            throw IllegalArgumentException()
        }
       return costState
    }

    private fun getState(cost: Int?): LottoInputState.Cost {
        return when {
            cost == null -> LottoInputState.Cost.IS_NULL
            cost % 1000 != 0 -> LottoInputState.Cost.NOT_DIVISIBLE_BY_1000
            cost <= 0 -> LottoInputState.Cost.IS_NOT_NATURAL_NUMBER
            else -> LottoInputState.Cost.SUCCESSFUL
        }
    }


}
