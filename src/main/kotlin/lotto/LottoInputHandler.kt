package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.validator.LottoCostInputState
import lotto.validator.LottoCostInputValidator

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine().toIntOrNull()
        try{
            LottoCostInputValidator.isValidCost(cost)
        } catch (e : IllegalArgumentException){
            receiveLottoCost()
        }
        return cost!!
    }



}