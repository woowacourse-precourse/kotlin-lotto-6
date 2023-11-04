package lotto

import camp.nextstep.edu.missionutils.Console

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine().toIntOrNull()

        return if(isValidCost(cost)) cost!! else throw IllegalArgumentException("")
    }

    fun isValidCost(cost : Int?) : Boolean{
        cost?.let {
            if(isMultipleOfThousand(it)){
                return true
            }
        }
        return false
    }

    private fun isMultipleOfThousand(int : Int): Boolean = int % 1000 == 0

}