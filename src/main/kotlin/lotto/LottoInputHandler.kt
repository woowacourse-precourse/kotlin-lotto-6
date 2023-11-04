package lotto

import camp.nextstep.edu.missionutils.Console

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine().toIntOrNull()

        return if(isValidCost(cost)) cost!! else throw IllegalArgumentException("")
    }

    fun isValidCost(cost : Int?) : Boolean{
        cost?.let {
            if(isMultipleOfThousand(it) == LottoCostInputState.SUCCESSFUL && isNaturalNumber(it) == LottoCostInputState.SUCCESSFUL){
                return true
            }
        }
        return false
    }

    private fun isMultipleOfThousand(int : Int) = if(int % 1000 == 0) LottoCostInputState.SUCCESSFUL else LottoCostInputState.NOT_DIVISIBLE_BY_1000

    private fun isNaturalNumber(int : Int) = if (int > 0) LottoCostInputState.SUCCESSFUL else LottoCostInputState.IS_NOT_NATURAL_NUMBER

}