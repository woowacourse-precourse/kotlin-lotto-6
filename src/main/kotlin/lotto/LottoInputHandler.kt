package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.utils.validator.LottoCostInputState
import lotto.utils.validator.LottoCostInputValidator

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine().toIntOrNull()
        try{
            LottoCostInputValidator.isValid(cost)
        } catch (e : IllegalArgumentException){
            receiveLottoCost()
        }
        return cost!!
    }




}