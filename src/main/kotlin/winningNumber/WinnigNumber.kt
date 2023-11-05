package winningNumber

import camp.nextstep.edu.missionutils.Console
import output.UserInterface

class WinnigNumber {
    var winningNumber = listOf<String>()
    fun inputWinningNumber(){
        println(UserInterface.INPUT_WINNING_NUMBERS.mention)
        winningNumber = Console.readLine().split(",")
        println("WinningNumber : $winningNumber")
    }

    fun inputBonusNumber(){
        println(UserInterface.INPUT_BONUS_NUMBERS.mention)
        var bonusNumber = Console.readLine()
        winningNumber += bonusNumber
        println("add bonusNumber : $winningNumber")
    }

    fun checkWinningNumberSpace(){

    }
}