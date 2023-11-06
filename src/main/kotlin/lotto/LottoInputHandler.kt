package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.utils.validator.LottoCostInputState
import lotto.utils.validator.LottoCostInputValidator
import lotto.utils.validator.LottoWinningNumbersInputValidator

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine().toIntOrNull()
        try{
            LottoCostInputValidator.validate(cost)
        } catch (e : IllegalArgumentException){
            return receiveLottoCost()
        }
        return cost!!
    }

    fun receiveLottoWinningNumbers() : List<Int>{
        val numbers = Console.readLine()
            .split(",")
        try{
            LottoWinningNumbersInputValidator.validate(numbers)
        } catch (e : IllegalArgumentException){
            return receiveLottoWinningNumbers()
        }

        return numbers.map { it.toInt() }
    }


}