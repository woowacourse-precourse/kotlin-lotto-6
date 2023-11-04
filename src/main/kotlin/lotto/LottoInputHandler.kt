package lotto

import camp.nextstep.edu.missionutils.Console

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine().toIntOrNull()

        return if(isValidCost(cost)) cost!! else throw IllegalArgumentException("")
    }

    fun isValidCost(cost : Int?) : Boolean{
        cost?.let {
            if(isMultipleOfThousand(it) == LottoCostInputState.SUCCESSFUL && isInRange(it) == LottoCostInputState.SUCCESSFUL){
                return true
            }
        }
        return false
    }

    private fun isMultipleOfThousand(int : Int) = if(int % 1000 == 0) LottoCostInputState.SUCCESSFUL else LottoCostInputState.NOT_DIVISIBLE_BY_1000

    private fun isInRange(int : Int) = if (int <= 45 && int >= 1) LottoCostInputState.SUCCESSFUL else LottoCostInputState.OUT_OF_RANGE

}