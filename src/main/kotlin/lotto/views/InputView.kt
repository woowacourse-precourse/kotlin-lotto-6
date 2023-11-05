package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*

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
    fun enterWinningNumber(): List<Int> {
        val input = Console.readLine()
        val splitInput = input.split(",")
        try {
            return winningNumberErrorCheck(input, splitInput)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
        return enterWinningNumber()
    }

    fun enterBonusNumber(winningNumber :List<Int>): Int {
        val bonus = Console.readLine()
        try{
            return bonusNumberErrorCheck(winningNumber, bonus)
        }catch (e:IllegalArgumentException){
            println("[ERROR] ${e.message}")
        }
        return enterBonusNumber(winningNumber)
    }
}