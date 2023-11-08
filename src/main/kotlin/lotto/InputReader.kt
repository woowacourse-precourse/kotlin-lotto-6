package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.BonusNumber.Companion.processBonusNumber

class InputReader {
    private fun <T> readInputWithRetry(processor: (String) -> T): T {
        while (true) {
            try {
                val userInput: String = Console.readLine()
                return processor(userInput)
            } catch (exception: IllegalArgumentException) {
                println("${exception.message}")
            }
        }
    }

    fun readPurchasePrice(): Int = readInputWithRetry(PurchaseAmount::processPurchaseAmount)

    fun readWinningNumber(): Lotto = readInputWithRetry(WinningNumber::processWinningNumber)

    fun readBonusNumber(winningTicket: Lotto): Int =
        readInputWithRetry { input -> processBonusNumber(input, winningTicket) }
}
