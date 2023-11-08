package winningNumber

import camp.nextstep.edu.missionutils.Console
import output.UserInterface

class WinningNumber {
    fun inputWinningNumber(): MutableList<String> {
        var winningNumber = mutableListOf<String>()
        while (true) {
            println(UserInterface.INPUT_WINNING_NUMBERS.mention)
            try {
                winningNumber = Console.readLine().split(",").toMutableList()
                WinningNumberValidate().checkWinningNumber(winningNumber)
                return winningNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
            println("WinningNumber : $winningNumber")
        }
    }
}
