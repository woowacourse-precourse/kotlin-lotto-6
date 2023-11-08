package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.view.OutputConsole.printInvalidNumbers
import lotto.view.OutputConsole.printNonNumericMessage

object InputConsole {

    fun getParsedNumbers(): List<Int> =
        try {
            Console.readLine().split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            printInvalidNumbers()
            getParsedNumbers()
        }

    fun getNumber(): Int =
        try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            printNonNumericMessage()
            getNumber()
        }
}