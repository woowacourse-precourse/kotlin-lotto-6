package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.view.OutputConsole.printNonNumericMessage

object InputConsole {

    fun getNumber(): Int =
        try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            printNonNumericMessage()
            getNumber()
        }
}