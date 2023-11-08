package winningNumber

import camp.nextstep.edu.missionutils.Console
import output.UserInterface

class BonusNumber {
    fun inputBonusNumber(winningNumber: MutableList<String>): MutableList<String> {
        while (true) {
            println(UserInterface.INPUT_BONUS_NUMBERS.mention)
            try {
                var bonusNumber = Console.readLine()
                BonusNumberValidate().checkBonusNumber(bonusNumber, winningNumber)
                winningNumber.add(bonusNumber)
                return winningNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
