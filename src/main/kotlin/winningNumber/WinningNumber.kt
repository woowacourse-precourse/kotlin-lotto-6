package winningNumber

import camp.nextstep.edu.missionutils.Console
import output.UserInterface

class WinningNumber {
    var winningNumber = listOf<String>()
    fun inputWinningNumber(): List<String>{
        while (true) {
            println(UserInterface.INPUT_WINNING_NUMBERS.mention)
            try {
                winningNumber = Console.readLine().split(",")
                WinningNumberCheck().checkWinningNumber(winningNumber)
                return winningNumber
            }catch (message: IllegalArgumentException){
                message.printStackTrace()
            }
            println("WinningNumber : $winningNumber")
        }
    }

    fun inputBonusNumber(){
        println(UserInterface.INPUT_BONUS_NUMBERS.mention)
        var bonusNumber = Console.readLine()
        winningNumber += bonusNumber
        println("add bonusNumber : $winningNumber")
    }
}