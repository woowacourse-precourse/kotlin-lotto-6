package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.utils.validator.LottoCostInputValidator
import lotto.utils.validator.LottoWinningNumberInputValidator

object LottoInputHandler {
    fun receiveLottoCost() : Int{
        val cost = Console.readLine()
        try{
            LottoCostInputValidator.validate(cost)
        } catch (e : IllegalArgumentException){
            return receiveLottoCost()
        }
        return cost.toInt()
    }

    fun receiveLottoWinningNumbers() : List<Int>{
        val numbers = Console.readLine()
            .split(",")
        numbers.forEach {
            try{
                LottoWinningNumberInputValidator.validate(it)
            } catch (e : IllegalArgumentException){
                return receiveLottoWinningNumbers()
            }
        }
        return numbers.map { it.toInt() }
    }

    fun receiveLottoBonusNumber() : Int {
        val bonusNumber = Console.readLine()
        try{
            LottoWinningNumberInputValidator.validate(bonusNumber)
        } catch (e : IllegalArgumentException){
            return receiveLottoBonusNumber()
        }
        return bonusNumber.toInt()
    }

}