package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.domain.blankCheck
import lotto.domain.moneyCheck
import lotto.domain.numberCheck

object InputView {
    fun enterMoney(): Int {
        val input = Console.readLine()
        try{
            blankCheck(input)
            numberCheck(input)
            val money = input.toInt()
            moneyCheck(money)
            return money
        }catch(e:IllegalArgumentException){
            println("[ERROR] ${e.message}")
        }
        return enterMoney()
    }

}