package lotto.utils.validator

import lotto.LottoOutputHandler

object LottoCostInputValidator {
    fun isValidCost(cost: Int?) : LottoCostInputState {
        val inputState = validateCost(cost)
        if (inputState != LottoCostInputState.SUCCESSFUL){
            LottoOutputHandler.displayLottoCostErrorMessage(inputState)
            throw IllegalArgumentException()
        }
       return inputState
    }

    private fun validateCost(cost: Int?): LottoCostInputState {
        return when {
            cost == null -> LottoCostInputState.IS_NULL
            cost % 1000 != 0 -> LottoCostInputState.NOT_DIVISIBLE_BY_1000
            cost <= 0 -> LottoCostInputState.IS_NOT_NATURAL_NUMBER
            else -> LottoCostInputState.SUCCESSFUL
        }
    }
}
